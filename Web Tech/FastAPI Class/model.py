from pydantic import BaseModel

class Item(BaseModel):
    id = 1
    name = "Oppo"
    price = 1000