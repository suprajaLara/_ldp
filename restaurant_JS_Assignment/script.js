var tablesData=[
    {
      "name":"Table 1",
      "totalItems":0,
      "totalPrice":0.0,
      "orders":[]
    },
    {
      "name":"Table 2",
      "totalItems":0,
      "totalPrice":0.0,
      "orders":[]
    },
    {
      "name":"Table 3",
      "totalItems":0,
      "totalPrice":0.0,
      "orders":[]
    }
 ];

var itemsData=[{
            "name":"Crusty Garlic Focaccia with Melted Cheese",
            "price":"150.00"

          },
          {
              "name":"Delight Pizza",
              "price":"200.00"

          },
          {
            "name":"French Fries",
            "price":"120.00"

          },
          {
            "name":"French Fries with Cheese & Jalapenos",
            "price":"135.00"

          },
          {
            "name":"Chicken and Cheese Burger",
            "price":"190.00"

          }
 ];

const items= document.querySelectorAll(".item");
const tables=document.querySelectorAll(".table")

items.forEach(item =>{
    item.addEventListener("dragstart",function(event){
        //get id of draggable element
        event.dataTransfer.setData("itemId",event.target.id);
         console.log(event.dataTransfer.getData('itemId'))
            console.log(event.target.innerHTML)
    })
});

var modal = document.getElementById("myModal");

tables.forEach(t => {
    t.addEventListener("dragenter",function dragEnter(e) {
                                       e.preventDefault();
                                       e.target.classList.add('drag-over');
                                   })
    t.addEventListener("dragover",function dragOver(e) {
                                      e.preventDefault();
                                      e.target.classList.add('drag-over');
                                  })
    t.addEventListener("dragleave",function dragLeave(e) {
                                       e.preventDefault();
                                       e.target.classList.remove('drag-over');
                                   })
    t.addEventListener("drop",function drop(e) {
                                  e.target.classList.remove('drag-over');
                                  var id = e.dataTransfer.getData('itemId');
                                  var tableno=e.target.id[5]
                                  console.log("drop")
                                  console.log(tableno)
                                  extractDataAndStore(id,tableno)
                                  console.log("Dropping in "+tableno)
                                  loadTableData()
                              })
    t.addEventListener("click",()=>
    {
        modal.style.display = "block";
        let tno=t.id[5]; // for string, "table1" -> 5th index is table no.
        localStorage.setItem("currentTable",tno);
        displayOrders(tno);
    })
});

function extractDataAndStore(id,tableno){
    let namesrc = "#"+id+" "+"h3";
    let pricesrc = "#"+id+" "+"p";
    console.log(namesrc)

    let name=document.querySelector(namesrc).textContent
    let price=document.querySelector(pricesrc).textContent
    var order = [name, price, 1]

     console.log(tablesData[tableno-1].orders.length);
     var len=tablesData[tableno-1].orders.length;

     for(i=0;i<len;i++)
    {
        let itemname=tablesData[tableno-1].orders[i][0]
        console.log(itemname,name)
        if(itemname===name)
         {
            tablesData[tableno-1].orders[i][2]=parseInt(tablesData[tableno-1].orders[i][2])+1
            console.log("Same name")
            break;
         }
    }
    if(i===len)
    {
        tablesData[tableno-1].orders[len]=order
        var items= (tablesData[tableno-1].totalitems)!=undefined ? tablesData[tableno-1].totalitems : 0;

        tablesData[tableno-1].totalitems= items +1
    }
    var tempPrice= (tablesData[tableno-1].totalprice)!=undefined ? tablesData[tableno-1].totalprice : 0.0 ;
    tablesData[tableno-1].totalprice=tempPrice+parseFloat(price)

}

function loadTableData(){
    for(let i=0;i<tables.length;i++)
        {
            var name=tablesData[i].name
            var price= (tablesData[i].totalprice)!=undefined ? tablesData[i].totalprice : 0.0 ;
            var items= (tablesData[i].totalitems)!=undefined ? tablesData[i].totalitems : 0;

            tables[i].innerHTML="<h3 >"+name+"</h3><p>Rs."+price+" | Total items:"+items+"</p>";
        }
}

function loadMenuData()
{
    for(i=0;i<items.length;i++)
    {
        items[i].innerHTML="<h3>"+itemsData[i].name+"</h3><p>"+itemsData[i].price+"</p>"
    }

}

function searchMenu()
{
    //resetting
    for(i=0;i<items.length;i++)
    {
        items[i].style.display=""
    }
    console.log("searching")

    var text=document.getElementById("menuSearch").value.toUpperCase();
    for(i=0;i<items.length;i++)
    {
        let itemname=itemsData[i].name;
        if(!itemname.toUpperCase().includes(text))
        {
            items[i].style.display="none"
        }
    }

}

function searchTable()
{
    //resetting
    for(i=0;i<tables.length;i++)
    {
        tables[i].style.display=""
    }
    console.log("searching")
    var text=document.getElementById("tableSearch").value.toUpperCase();
    for(i=0;i<tables.length;i++)
    {
        let tablename=tablesData[i].name
        if(!tablename.toUpperCase().includes(text))
        {
            tables[i].style.display="none"

        }
    }
}

var span = document.querySelector(".close");

span.onclick = function() {
  modal.style.display = "none";
}
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

function displayBill(tableno){
    var orders=tablesData[tableno-1].orders
    var bill=document.getElementById("totalBill")
    var session=document.getElementById("sessionClose")
    var text="<table class='table'><thead class=''><tr>"
            +"<th>S.no</th>"
             +"<th>Item</th>"
             +"<th>Price(Rs.)</th>"
             +"<th>Quantity</th>"
             +"</tr></thead>";

    for(i=0;i<orders.length;i++)
    {
        let j=i+1;
        text+="<tr><td>"+j+"</td><td>"+orders[i][0]+"</td><td>"+orders[i][1]+"</td><td>"+orders[i][2]+"</td></tr>"
    }
    var modalbody=document.querySelector(".modal-body");
    bill.innerHTML="TOTAL BILL :"+tablesData[tableno-1].totalprice
    session.innerHTML=''
    modalbody.innerHTML=text

    tablesData[tableno-1].totalitems=0
    tablesData[tableno-1].totalprice=0
    tablesData[tableno-1].orders=[]
    //console.log(data);

    loadTableData()
}


function displayOrders(tableno)
{
    console.log("displaying Table No "+tableno)
    var header=document.getElementById("header")
    header.innerHTML=" Table "+tableno+" | Order-Details"

    var orders=tablesData[tableno-1].orders
    var modalbody=document.querySelector(".modal-body");
    var bill=document.getElementById("totalBill")
    var closesession=document.getElementById("sessionClose")

    if(orders.length===0)
    {
    modalbody.innerHTML="<br><br><h1 style='text-align: center;'>No Orders</h1>"
    bill.innerHTML=''
    closesession.innerHTML=''
    return
    }
    var totalBill=0
    var text="<table><tr>"
        +"<th>S.no</th>"
         +"<th>Item</th>"
         +"<th>Price(Rs.)</th>"
         +"<th> </th>"
         +"<th> </th></tr>"
    for(i=0;i<orders.length;i++)
    {
    let j=i+1;
    totalBill+=(orders[i][1]*orders[i][2])
     text+="<tr><td>"+j+"</td><td>"+orders[i][0]+"</td><td>"+orders[i][1]+"<td><p class=''>Number of Servings</p><input type='number' id='quantity"+i+"'"+"value='"+(orders[i][2])+"' onchange='updateQuantity("+tableno+","+i+")' min='1'></td>"+ "<td><i class='fa fa-trash' onclick='deleteItem("+i+","+tableno+")' id='deletebtn'></i></td></tr>";
    }

    bill.innerHTML="TOTAL BILL :"+tablesData[tableno-1].totalprice
    closesession.innerHTML="CLOSE SESSION(GENERATE BILL)"
    modalbody.innerHTML=text
}

var billgenerator =document.getElementById("sessionClose")
billgenerator.addEventListener("click",()=>{
    var tablenum=localStorage.getItem("currentTable")
    displayBill(tablenum)
})

function updateQuantity(tableno,i)
{
    var price=tablesData[tableno-1].orders[i][1]
    var prevservings=tablesData[tableno-1].orders[i][2]
    console.log(tablesData[tableno-1])

    var q=document.getElementById("quantity"+i).value
    console.log(q)
    tablesData[tableno-1].orders[i][2]=q;
    tablesData[tableno-1].totalprice-=(price*prevservings)
    tablesData[tableno-1].totalprice+=(q*price)
    loadTableData()
    displayOrders(tableno)
}

function deleteItem(i,tableno)
{
    console.log(i,tableno)
    var len=tablesData[tableno-1].orders.length
    var price=tablesData[tableno-1].orders[i][1]
    var prevservings=tablesData[tableno-1].orders[i][2]
    var updatedData=tablesData[tableno-1].orders.slice(0,i).concat(tablesData[tableno-1].orders.slice(i+1,len));
    tablesData[tableno-1].orders=updatedData
    tablesData[tableno-1].totalitems-=1
    tablesData[tableno-1].totalprice-=(price*prevservings)
    loadTableData()
    displayOrders(tableno)
}