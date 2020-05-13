import 'package:flutter/material.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class PaymentType extends StatefulWidget {
  @override
  _PaymentTypeState createState() => _PaymentTypeState();
}

class _PaymentTypeState extends State<PaymentType> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Payment Type"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
      padding: EdgeInsets.fromLTRB(0, 10, 0, 20),
       child: ListView(children: <Widget>[
         SizedBox(height: 20,),
         GestureDetector(
            child: listTile('One Time Payment'),
            onTap: (){
              Navigator.pushNamed(context, 'paymentmode');
            },
         ),
         SizedBox(height: 15),
         GestureDetector(
            child: listTile('Recurring Payment'),
            onTap: (){
              Navigator.pushNamed(context, 'recurringpayment');
            },
         ),
       ],),
    ),
    );
  }

  Widget listTile(String title  ){
    return ListTile(
      leading: Icon(Icons.payment),
      trailing: Icon(Icons.keyboard_arrow_right),
      title: Text(title, style: TextStyle(fontSize: 20,), ),
      // subtitle: Text(subTitle),
    );
  }
}