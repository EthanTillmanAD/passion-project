TO BUILD A COMPUTER ENDPOINTS DEMO

before building a computer we need to build all the other components first

we can start with a cpu

using end point http://localhost:8080/cpu and the post CRUD point
cpu requires a name and cores an id and title will automatically be assigned

{
    "name": "i9-8600k",
    "cores": 16
}


using end point http://localhost:8080/graphics and post CRUD point
graphics requires a name and a gb size 

{
    "name" : "gtx1080",
    "size" : "SMALL"
}

using end point http://localhost:8080/ssd and post CRUD point
ssd requires name and gb size as well

{
    "name" : "some ssd",
    "size" : "SMALL"
}

using end point http://localhost:8080/hdd and post CRUD point
hdd requires name and gb size as well

{
    "name" : "some hdd",
    "size" : "SUPER"
}

using end point http://localhost:8080/ram and post CRUD point
ram requires name and gb size as well

{
    "name" : "tridentz ",
    "size" : "MED"
}

each one of these are required to make a motherboard, they all have all the end points as well
such as read all or by id, delete by id or update by id

to create a motherboard we use endpoint http://localhost:8080/motherboard/cpu/{cpuId}/graphics/{grahpicsId}/ssd/{ssdId}/hdd/{hddId}/ramOne/{ramIdOne}/ramTwo/{ramTwoId}/?name={name}

this will create a motherboard in the database that we can use to create a computer
we can also update components inside such as cpu and graphics or add like ram and ssd/hdd
ram requires 2 different types to be able to function and ssd/hdd can have 1 to many


next we can create a powersupply and case

using endpoints http://localhost:8080/power and post CRUD point
power Supply requires name and watts

{
    "name": "Corsair GOLD+",
    "watts": 900
}

using endpoints http://localhost:8080/case and post CRUD point
case requires a name and color

{
    "name": "Cool case 10000",
    "color": "red"
}

with the case and power supply we can create a computer

to create use endpoint http://localhost:8080/computer/motherboard/{motherboardId}/case/{caseId}/power/{powerId}/?name={name}

we can find by id for all using endpoints above with /{id} after them with the id number
we can list them all remove or update them

we have two search methods by part such as the title they are given or
the name they have

to search by title/type of component use endpoint http://localhost:8080/search/title?title={title}

or we can search by name by using http://localhost:8080/search/name?name={name}