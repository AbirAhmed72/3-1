from model import Item
from fastapi import FastAPI

app = FastAPI()

@app.get('/')
async def read_root(): # type: ignore
    return {'message': 'Hello World'}

@app.get('/{id}')
async def get_int(id: int):
    return {'message': 'Hello123'}

@app.get('/int/{id}', response_model=int)
async def read_int(id: int):
    return id

@app.get('/bool/{status}', response_model=bool)
async def read_bool(status: bool):
    return status

@app.post("/item/", response_model=Item)
async def post_item(item: Item):
    return item

@app.put("/item/", response_model=Item)
async def put_item(item: Item):
    return item

@app.delete("/item/", response_model=Item)
async def delete_item(item: Item):
    return item

