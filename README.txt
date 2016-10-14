
i)POINT OF SALE REGISTRY

ii)A and B)The costs and sales are being handled in the same ArrayList which is called Products Database in the PointOfSale class. They are both read
in the method readCosts and readSales from the class Sales. In the method initialize that is run at the start of the application we first
loop the costs read by the readCosts method and then the sales. After we match every piece of information we have on the product available from both files and
we do a switch case if both files have the same unique SKU,therefore, that product will have some type of discount. 
Once the sale type is detected (there could be no sale at all), the objects (products) are created and added to the arraylist product database. 
Each obejct is creating from a different child bass depending on their sale which could be either BuyXForY, BuyXget1Free, Discount or Without Sale which are all child classes
from the parent class Sales. 
In each of these four classes we will make the operations associated to each one including the printing in the register tape. So, for example for the class 
DiscountSales, the operation method will multiply the unit price of the product by the discount applied to make the discount and will call the class View in order 
to update the record instantly in the register tape.
Additionally, we have a sales type which is an enumerate to classify the 4 possible types of discounts. Threfore, the costs are saved in the first 3 columns
and the sales will be saved in the 4th and 5th column. 
By joining both text files we eliminate many redundancies, making the program much more efficient.

c)In order to control the customer order we need to analyse what is being done in the Point Of Sale Model.
The first thing we do is check whether the sku introduced is valid, checking whether it is a valid one, having 6 digits and being part of the database. Then, we will 
increment the number of units bought by the customer and display the updated record by calling the refresh method. Therefore, depending on the product's sku, 
one or another thing will be shown in the screen with its unit price and total. Once the order has been finished, the pay button is clicked
and this will be saved in the register tape and would be ready for the next order.
In the case, of making a mistake or entering the wrong products, by pressing void everything will eliminate from the screen.

iii) I had some difficulties implementing this problem. First of all, putting the scroll panel was easy in the view, but it wasn't that easy to set its value compared to jtextfields.
Another thing I had problems with, was being able to compare all the possible sku from the database to the one given from the user,
to check it is a valid sku. Additionally, it was hard implementing the most adecuate number format which were common to all the required method, in order
to do this I used the number format that I specified to be x numbers of precision and only two number after the decimal point.

iv) All the requirements were successfully done.

v) There was one interpretation which, in my opinion, gave a little of flexibility. This was in the case of ordering an item, then ordering a different one and then
the same one again. For example, buying bananas, a book and then another book. It wasn't clear if both records of bananas had to show separately in the register tape
or not if they were bought in desorder. However, I thought in a practical way on how the shops are being implemented these days, and I decided to join the products
in the same line even though there were products from different types in the middle. Referring to my example, my register tape will show banana quantity 2 and a 
book with their equivalent prices. 	

vi) I would rate the complexity of this project of a 7 because it was a mixture of the three projects done before, but still had to be careful on how me mixed them.
Also, there were new implementations we had to be aware of.		