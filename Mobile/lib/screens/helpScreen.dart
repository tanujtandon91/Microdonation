import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:one_relief/screens/charityInfo.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class HelpScreen extends StatefulWidget {
  @override
  _HelpScreenState createState() => _HelpScreenState();
}

class _HelpScreenState extends State<HelpScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Help'),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
      padding: EdgeInsets.fromLTRB(0, 10, 0, 20),
       child: ListView(children: <Widget>[
         Container(
           padding: EdgeInsets.fromLTRB(20, 10, 0, 20),
           child: Column(
             children: <Widget>[
               Text(StringsAll.help_text),
             ],
           ),
         ),
         GestureDetector(
            child: listTile(Icons.security, 'Security', '18:30'),
            onTap: (){
              
            },
         ),
         GestureDetector(
            child: listTile(Icons.account_circle, 'Personalization.', '15:29'),
            onTap: (){
              
            },
         ),
         GestureDetector(
            child: listTile(Icons.payment, 'Payments.', '12:00'),
            onTap: (){
              
            },
         ),
         GestureDetector(
            child: listTile(Icons.update, 'Update App', '07:00'),
            onTap: (){
              
            },
         ),
         GestureDetector(
            child: listTile(Icons.business, 'Organisation Information ', '00:00'),
            onTap: (){
              
            },
         ),
       ],),
    ),
    );
  }

  Widget listTile(IconData icon, String title, String subTitle){
    return ListTile(
      leading: CircleAvatar(
        child: Icon(icon), 
        backgroundColor: UIColors.orangeColor,
      ),
      trailing: IconButton(
        icon: Icon(Icons.arrow_right), 
        onPressed: (){
          Fluttertoast.showToast(msg: title, toastLength: Toast.LENGTH_LONG);
        }
      ),
      title: Text(title),
      // subtitle: Text(subTitle),
    );
  }
}