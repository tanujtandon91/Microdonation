import 'package:flutter/material.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class Settings extends StatefulWidget {
  Settings({Key key}) : super(key: key);

  @override
  _SettingsState createState() => _SettingsState();
}

class _SettingsState extends State<Settings> {
  bool isSwitched = true;
  int radioHowOften;
  int radioWhatTime;

  void setRadioValues(bool isOften, int value){
    setState(() {
      isOften ? radioHowOften = value : radioWhatTime = value;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
        title: Text("Settings"),
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.only(left: 10, right: 10, bottom: 20),
          child: Center(child: Column(
            children: <Widget>[
              Card(
                child: Container(
                  padding: EdgeInsets.all(15),
                  width: double.infinity,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5)
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      WidgetStandarts.getText("Privacy Setting", 18, null, FontWeight.bold),
                      SizedBox(height: 10),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: <Widget>[
                        Flexible(
                          child: Column(
                            children: <Widget>[
                              Text(StringsAll.privacy_setting),
                            ],
                          ),
                        ),
                        Switch(
                          value: isSwitched,
                          onChanged: (value) {
                            setState(() {
                              isSwitched = value;
                            });
                          },
                        ),
                      ],)
                    ],
                  ),
                ),
              ),
              Card(
                child: Container(
                  padding: EdgeInsets.all(15),
                  width: double.infinity,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5)
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      WidgetStandarts.getText("Your monthly gift", 18, null, FontWeight.bold),
                      SizedBox(height: 10),
                      WidgetStandarts.getText("Your are not currently giving monthly.", null, null, null, UIColors.black54Color),
                    ],
                  ),
                ),
              ),
              Card(
                child: Container(
                  padding: EdgeInsets.all(15),
                  width: double.infinity,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5)
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: <Widget>[
                          WidgetStandarts.getText("Set remainder", 18, null, FontWeight.bold),
                          Switch(
                            value: isSwitched,
                            onChanged: (value) {
                              setState(() {
                                isSwitched = value;
                              });
                            },
                          ),
                        ],
                      ),
                      WidgetStandarts.getText("How often", 16, null, FontWeight.bold),
                      radioWidget(1, radioHowOften, "Once a day"),
                      radioWidget(2, radioHowOften, "Once a week"),
                      radioWidget(3, radioHowOften, "Once a month"),
                      radioWidget(4, radioHowOften, "Choose Specific Date"),
                      // Row(
                      //   children: <Widget>[
                      //     new Radio(
                      //       value: 1,
                      //       groupValue: radioHowOften,
                      //       onChanged: (value){
                      //         setRadioValues(true, value);
                      //       },
                      //     ),
                      //     WidgetStandarts.getText("Once a day", null, null, null, UIColors.black54Color),
                      //   ],
                      // ),
                      // Row(
                      //   children: <Widget>[
                      //     new Radio(
                      //       value: 2,
                      //       groupValue: radioHowOften,
                      //       onChanged: (value){
                      //         setRadioValues(true, value);
                      //       },
                      //     ),
                      //     WidgetStandarts.getText("Once a week", null, null, null, UIColors.black54Color),
                      //   ],
                      // ),
                      // Row(
                      //   children: <Widget>[
                      //     new Radio(
                      //       value: 3,
                      //       groupValue: radioHowOften,
                      //       onChanged: (value){
                      //         setRadioValues(true, value);
                      //       },
                      //     ),
                      //     WidgetStandarts.getText("Once a month", null, null, null, UIColors.black54Color),
                      //   ],
                      // ),
                      WidgetStandarts.getText("At what time", 16, null, FontWeight.bold),
                      radioWidget2(1, radioWhatTime, "Breakfast (8am)"),
                      radioWidget2(2, radioWhatTime, "Lunch (12pm)"),
                      radioWidget2(3, radioWhatTime, "Dinner (7am)"),
                    ],
                  ),
                ),
              ),
              // Card(
              //   child: Container(
              //     padding: EdgeInsets.all(15),
              //     width: double.infinity,
              //     decoration: BoxDecoration(
              //       borderRadius: BorderRadius.circular(5)
              //     ),
              //     child: Column(
              //       crossAxisAlignment: CrossAxisAlignment.start,
              //       children: <Widget>[
              //         WidgetStandarts.getText("Push Notifications", 18, null, FontWeight.bold),
              //         SizedBox(height: 10),
              //         Row(children: <Widget>[
              //           Flexible(
              //             child: Column(
              //               children: <Widget>[
              //                 Text(StringsAll.notificationText),
              //               ],
              //             ),
              //           ),
              //           Switch(
              //             value: isSwitched,
              //             onChanged: (value) {
              //               setState(() {
              //                 isSwitched = value;
              //               });
              //             },
              //           ),
              //         ],)
              //       ],
              //     ),
              //   ),
              // ),
            ],
          ),),
        ),
      ),
    );
  }

  radioWidget(int pValue, int groupName, String text){
    return Row(
      children: <Widget>[
        new Radio(
          value: pValue,
          groupValue: groupName,
          onChanged: (value){
            setRadioValues(true, value);
          },
        ),
        WidgetStandarts.getText(text, null, null, null, UIColors.black54Color),
      ],
    );
  }
  radioWidget2(int pValue, int groupName, String text){
    return Row(
      children: <Widget>[
        new Radio(
          value: pValue,
          groupValue: groupName,
          onChanged: (value){
            setRadioValues(false, value);
          },
        ),
        WidgetStandarts.getText(text, null, null, null, UIColors.black54Color),
      ],
    );
  }
}