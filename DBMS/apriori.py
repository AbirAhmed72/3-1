import pandas as pd

# Read the CSV file into a data frame, with the arrays separated by a comma
df = pd.read_csv('D:\\Poralekha\\3-1\\DBMS\\apriori.csv', delimiter=',  ')
# df[['Column1', 'Column2']] = df['ArrayColumn'].str.split(', ', expand=True)
# Print the data frame
print(df)