from databases import Database
from model import Item

database = Database('mysql+aiomysql://root:@localhost:3306/cw')

async def connect_db():
    await database.connect()

async def insert(item: Item):
    query = "insert into item(name,price) values(:name,:price)"
    values = {"name": item.name, "price": item.price}
    await database.execute(query=query, values=values)
