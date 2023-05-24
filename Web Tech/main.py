from fastapi import FastAPI, UploadFile, File
import mysql.connector
import base64
import os

app = FastAPI()

def get_connection():
    # Replace with your MySQL database credentials
    return mysql.connector.connect(
        user="root",
        host="localhost",
        password="",
        database="onlinedoctor"
    )

@app.post('/doctorRegister')
async def doctor_register(
    firstName: str,
    lastName: str,
    gender: str,
    age: int,
    phoneNumber: str,
    email: str,
    fatherName: str,
    motherName: str,
    doctorRegNumber: str,
    specialization: str,
    username: str,
    password: str,
    photo: UploadFile = File(...),
    doctorDegree: list[UploadFile] = File(...)
):
    photo_references = []
    doctor_degree_references = []

    # Save photo and doctorDegree files
    for file in [photo] + doctorDegree:
        file_extension = os.path.splitext(file.filename)[1]
        file_path = f"doctorsFolder/{file.filename}"
        with open(file_path, "wb") as f:
            f.write(file.file.read())
        if file.field_name == "photo":
            photo_references.append(file_path)
        elif file.field_name == "doctorDegree":
            doctor_degree_references.append(file_path)

    connection = get_connection()
    cursor = connection.cursor()

    insert_query = """
        INSERT INTO doctors (firstName, lastName, email, phoneNumber, fatherName, motherName, gender, age, doctorRegNumber, specialization, doctorDegree, photo, username, password, account_status, deletion_date)
        VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, NULL)
    """
    values = (
        firstName, lastName, email, phoneNumber, fatherName, motherName, gender, age, doctorRegNumber, specialization,
        doctor_degree_references, photo_references, username, password, 'active'
    )

    cursor.execute(insert_query, values)
    connection.commit()
    cursor.close()
    connection.close()

    return {"message": "Doctor registered successfully"}


@app.post('/patientRegister')
async def patient_register(
    firstName: str,
    lastName: str,
    gender: str,
    age: int,
    email: str,
    fatherName: str,
    motherName: str,
    username: str,
    password: str,
    photo: UploadFile = File(...)
):
    photo_reference = f"patientsFolder/{photo.filename}"
    with open(photo_reference, "wb") as f:
        f.write(photo.file.read())

    connection = get_connection()
    cursor = connection.cursor()

    insert_query = """
        INSERT INTO patients (username, firstName, lastName, gender, age, email, fatherName, motherName, password, photo, account_status, deletion_date)
        VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, NULL)
    """
    values = (
        username, firstName, lastName, gender, age, email, fatherName, motherName, password, photo_reference, 'active'
    )

    cursor.execute(insert_query, values)
    connection.commit()
    cursor.close()
    connection.close()

    return {"message": "Patient registered successfully"}


@app.post('/login')
def login(user: str, username: str, password: str):
    connection = get_connection()
    cursor = connection.cursor()

    if user == "doctors":
        query = "SELECT * FROM doctors WHERE username = %s AND password = %s"
    elif user == "patients":
        query = "SELECT * FROM patients WHERE username = %s AND password = %s"
    elif user == "admin":
        query = "SELECT * FROM admin WHERE username = %s AND password = %s"
    else:
        return {"message": "Invalid user type"}

    cursor.execute(query, (username, password))
    result = cursor.fetchall()

    cursor.close()
    connection.close()

    if not result:
        return {"message": "Wrong username or password"}

    return {"message": user}


@app.post('/bookAppointment')
def book_appointment(password: str, doctor: str, timeDate: str, username: str = "rana"):
    connection = get_connection()
    cursor = connection.cursor()

    insert_query = "INSERT INTO appointment (username, doctor, timeDate) VALUES (%s, %s, %s)"
    values = (username, doctor, timeDate)

    cursor.execute(insert_query, values)
    connection.commit()
    cursor.close()
    connection.close()

    return {"message": "Appointment booked successfully"}


@app.get('/allDoctorList')
def all_doctor_list():
    connection = get_connection()
    cursor = connection.cursor()

    select_query = "SELECT username, firstname, lastname, gender, age, email, phonenumber, specialization, photo FROM doctors"
    cursor.execute(select_query)
    result = cursor.fetchall()

    doctor_list = []
    for doctor_info in result:
        photo_path = doctor_info["photo"]
        with open(photo_path, "rb") as f:
            photo_data = f.read()
        base64_photo = base64.b64encode(photo_data).decode("utf-8")

        doctor_list.append({
            "username": doctor_info["username"],
            "firstname": doctor_info["firstname"],
            "lastname": doctor_info["lastname"],
            "gender": doctor_info["gender"],
            "age": doctor_info["age"],
            "email": doctor_info["email"],
            "phonenumber": doctor_info["phonenumber"],
            "specialization": doctor_info["specialization"],
            "photo": base64_photo,
        })

    cursor.close()
    connection.close()

    return {"message": doctor_list}
