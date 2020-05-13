import 'package:flutter/material.dart';
import 'package:one_relief/screens/charityInfo.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class NotificationScreen extends StatefulWidget {

  @override
  _NotificationScreenState createState() => _NotificationScreenState();
}

class _NotificationScreenState extends State<NotificationScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Notifications'),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
      padding: EdgeInsets.fromLTRB(0, 10, 0, 20),
       child: ListView(children: <Widget>[
         GestureDetector(
            child: listTile('Please update your application', '18:30'),
            onTap: (){
              Fluttertoast.showToast(msg: "Please update your application", toastLength: Toast.LENGTH_LONG);
            },
         ),
         GestureDetector(
            child: listTile('We are organising the event. Please check the schedule.', '15:29'),
            onTap: (){
              Fluttertoast.showToast(msg: "We are organising the event. Please check the schedule.", toastLength: Toast.LENGTH_LONG);
            },
         ),
         GestureDetector(
            child: listTile('We are offering the scheme.', '12:00'),
            onTap: (){
              Fluttertoast.showToast(msg: "We are offering the scheme.", toastLength: Toast.LENGTH_LONG);
            },
         ),
         GestureDetector(
            child: listTile('Happy Diwali Dear Donor', '07:00'),
            onTap: (){
              Fluttertoast.showToast(msg: "Happy Diwali Dear Donor", toastLength: Toast.LENGTH_LONG);
            },
         ),
         GestureDetector(
            child: listTile('Happy Birthday! You can celebrate with any child NGO.', '00:00'),
            onTap: (){
              Fluttertoast.showToast(msg: "Happy Birthday! You can celebrate with any child NGO.", toastLength: Toast.LENGTH_LONG);
            },
         ),
         
         
         
         
       ],),
    ),
    );
  }

  Widget listTile(String title, String time){
    return ListTile(
      // leading: CircleAvatar(child: Text('A'),backgroundColor: UIColors.orangeColor,),
      trailing: Text(time, style: TextStyle(fontWeight: FontWeight.bold),),
      title: Text(title),
      // subtitle: Text(subTitle),
    );
  }
}