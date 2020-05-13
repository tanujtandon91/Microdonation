import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:one_relief/screens/charityInfo.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class PaymentModeScreen extends StatefulWidget {
  @override
  _PaymentModeScreenState createState() => _PaymentModeScreenState();
}

class _PaymentModeScreenState extends State<PaymentModeScreen> {

  final _paymentMode_formkey = GlobalKey<FormState>();


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Payment Modes"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
      padding: EdgeInsets.fromLTRB(0, 10, 0, 20),
       child: ListView(children: <Widget>[
         Center(child: Text("Select a Payment Mode",
            style: TextStyle(
              fontSize: 22,
              fontWeight: FontWeight.bold,
              color: UIColors.black45Color
            ),
          ),
        ),
        SizedBox(height: 20,),
        Container(
          decoration: BoxDecoration(
            border: Border(left: BorderSide(),top: BorderSide(),bottom: BorderSide()),
          ),
          child: ListTile(
            title: Text("Saved Cards"),
          ),
        ),
        Container(
          decoration: BoxDecoration(
            border: Border(left: BorderSide(),bottom: BorderSide()),
          ),
          child: ListTile(
            title: Text("Credit Cards"),
          ),
        ),
        Container(
          decoration: BoxDecoration(
            border: Border(left: BorderSide(),bottom: BorderSide()),
          ),
          child: ListTile(
            title: Text("Net Banking"),
          ),
        ),
        Container(
          decoration: BoxDecoration(
            border: Border(left: BorderSide(),bottom: BorderSide()),
          ),
          child: ListTile(
            title: Text("Wallet"),
          ),
        ),
        Container(
          decoration: BoxDecoration(
            border: Border(left: BorderSide(),bottom: BorderSide()),
          ),
          child: ListTile(
            title: Text("UPI"),
          ),
        ),
        // listTile('Saved Cards'),
        // listTile('Credit Cards'),
        // listTile('Net Banking'),
        // listTile('Wallet'),
        // listTile('UPI'),
        SizedBox(height: 40.0,),
        Center(child: Buttons.roundedRectButton("Pay Now", UIColors.signUpGradients, validate),),
          // Center(child: GestureDetector(
          //   child: Buttons.roundedRectButton("Pay Now", UIColors.signUpGradients, validate),
          //   onTap: (){
          //     Fluttertoast.showToast(msg: "Pay Later");
          //   },
          // )),
       ],),
    ),
    );
  }

  validate(){
    Fluttertoast.showToast(msg: "Pay Later");
  }

  listTile(String label){
    return Container(
      decoration: BoxDecoration(
        border: Border(bottom: BorderSide()),
      ),
      child: ListTile(
        title: Text(label),
      ),
    );
  }
}