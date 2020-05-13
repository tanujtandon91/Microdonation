import 'package:flutter/material.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';

class WidgetStandarts {
  static double height;
  static double width;

  static BoxDecoration getHeaderDecoration(){
    return BoxDecoration(
        gradient: LinearGradient(
          colors: UIColors.orangeGradients,
        )
    );
  }

  static BottomAppBar getBottomAppBar(BuildContext context){
    return BottomAppBar(
      child: Container(
        padding: EdgeInsets.fromLTRB(10, 10, 10, 10),
        height: MediaQuery.of(context).size.height * 0.088,
        child: Row(
                children: <Widget>[
                Flexible(
                  child: Column(
                    children: <Widget>[
                      Text(StringsAll.contact_us_end, style: TextStyle( ),),
                    ],
                  ),
                ),
              ],),
        // child: Column(
        //   mainAxisAlignment: MainAxisAlignment.center,
        //   children: <Widget>[
        //     Text(
        //       StringsAll.contact_us_end,
        //       style: TextStyle(fontSize: 12.0, color: Colors.blue,), textAlign: TextAlign.center,
        //     ),
        //   ],
        // ),
      ));
  }

  static getText(String text,
      [double _fontSize, FontStyle _fontStyle, FontWeight _fontWeight, Color color]) {
    return FittedBox(
      fit: BoxFit.fill,
      child: Text(
        text,
        style: TextStyle(
          fontSize: _fontSize,
          fontWeight: _fontWeight,
          color: color,
        ),
      ),
    );
  }

  static BottomNavigationBar getBottomBar(
      [bool activeFlag, BuildContext context, int index]) {
    return BottomNavigationBar(
      unselectedItemColor: UIColors.black54Color,
      selectedItemColor: activeFlag ? Colors.orange : UIColors.black54Color,
      showUnselectedLabels: true,
      currentIndex: index,
      type: BottomNavigationBarType.fixed,
      items: [
        BottomNavigationBarItem(icon: Icon(Icons.menu), title: Text("Menu")),
        BottomNavigationBarItem(
            icon: Icon(Icons.border_clear), title: Text("My NGO")),
        BottomNavigationBarItem(
            icon: Icon(Icons.add_call), title: Text("Invite")),
        BottomNavigationBarItem(
            icon: Icon(Icons.add), title: Text("Reg Charity")),
        BottomNavigationBarItem(
            icon: Icon(Icons.account_circle), title: Text("Profile")),
      ],
      onTap: (int index) {
        switch (index) {
          case 0:
            pushWithRouteNameAndRemoveUntilMenu(context, 'dashboard');
            break;
          case 1:
            pushWithRouteNameAndRemoveUntilMenu(context, 'myngo');
            break;
          case 2:
            pushWithRouteNameAndRemoveUntilMenu(context, 'invitedonor');
            break;
          case 3:
            pushWithRouteNameAndRemoveUntilMenu(context, 'registercharity');
            break;
          case 4:
            pushWithRouteNameAndRemoveUntilMenu(context, 'updateprofile');
            break;
        }
      },
    );
  }

  static pushWithRouteNameAndRemoveUntilMenu(
      BuildContext context, String pushRouteName) {
    return Navigator.pushNamedAndRemoveUntil(
        context, pushRouteName, ModalRoute.withName('dashboard'));
  }

  static flatCancleButton(BuildContext context, String buttonName) {
    return FlatButton(
      color: UIColors.whiteColor,
      child: Text(
        buttonName,
        style: TextStyle(color: UIColors.blackColor),
      ),
      onPressed: () {
        Navigator.of(context).pop();
      },
    );
  }

  static submitAction(BuildContext context) {
    return showDialog(
        context: context,
        builder: (BuildContext context) {
          return SimpleDialog(
            title: Text("Successsul"),
            children: <Widget>[
              Container(
                padding:
                    EdgeInsets.only(left: 10, right: 10, top: 20, bottom: 20),
                child: Center(
                  child: Text("The record is succcessfully saved."),
                ),
              ),
              cancleOkButton(context, "OK"),
            ],
          );
        });
  }

  static cancleOkButton(context, btnName) {
    return Padding(
      padding: EdgeInsets.only(right: 27.0),
      child: new Row(
        mainAxisAlignment: MainAxisAlignment.end,
        children: <Widget>[
          WidgetStandarts.flatCancleButton(context, "CANCLE"),
          new ButtonTheme(
            minWidth: 60.0,
            height: 36.0,
            child: RaisedButton(
              child: Container(
                decoration: BoxDecoration(
                  gradient: LinearGradient(
                    colors: UIColors.orangeGradients
                  ),
                  borderRadius: BorderRadius.circular(20),
                ),
                padding: EdgeInsets.only(
                    top: 10.0, bottom: 10.0, left: 20.0, right: 20.0),
                child: Text(
                  btnName,
                  style: TextStyle(fontSize: 14.0),
                ),
              ),
              padding: EdgeInsets.all(0.0),
              shape: new RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(18.0)),
              textColor: UIColors.whiteColor,
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ),
        ],
      ),
    );
  }

  static void getWidthAndHeight(BuildContext context) {
    height = MediaQuery.of(context).size.height;
    width = MediaQuery.of(context).size.width;
  }

  static SizedBox getSizedBoxHeight(double h) {
    return SizedBox(height: height * (h));
  }

  static SizedBox getSizedBoxWidth(double w) {
    return SizedBox(width: width * (w));
  }

  static Widget loder() {
    return Center(child: CircularProgressIndicator());
  }

  static loderDialog(BuildContext context) {
    return showDialog(
        barrierDismissible: false,
        context: context,
        // builder: (BuildContext context) {
        //   return AlertDialog(
        //     content:
        //     Container(
        //         width: 35.0,
        //         height: 70.0,
        //         child:
        //         new Center(child: new CircularProgressIndicator())),
        //   );
        // }
        builder: (BuildContext context) {
          return Center(child: new CircularProgressIndicator());
        });
  }

  static Future<bool> createDialogue(BuildContext context) async {
    var returnValue = await showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: new Text('Are you sure?'),
            content: new Text('Do you want to delete the block'),
            actions: <Widget>[
              ButtonTheme(
                minWidth: 60.0,
                height: 36.0,
                child: RaisedButton(
                  child: Container(
                    padding: EdgeInsets.only(
                        top: 10.0, bottom: 10.0, left: 20.0, right: 20.0),
                    child: Text(
                      "No",
                      style: TextStyle(fontSize: 14.0),
                    ),
                  ),
                  padding: EdgeInsets.all(0.0),
                  shape: new RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(18.0)),
                  textColor: UIColors.whiteColor,
                  onPressed: () {
                    Navigator.of(context).pop(true);
                  },
                ),
              ),
              ButtonTheme(
                minWidth: 60.0,
                height: 36.0,
                child: RaisedButton(
                  child: Container(
                    padding: EdgeInsets.only(
                        top: 10.0, bottom: 10.0, left: 20.0, right: 20.0),
                    child: Text(
                      "YES",
                      style: TextStyle(fontSize: 14.0),
                    ),
                  ),
                  padding: EdgeInsets.all(0.0),
                  shape: new RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(18.0)),
                  textColor: UIColors.whiteColor,
                  onPressed: () {
                    Navigator.of(context).pop(true);
                  },
                ),
              ),
            ],
          );
        });
    return returnValue;
  }

  static loderDialogCircularIndicator(BuildContext context) {
    return showDialog(
      barrierDismissible: false,
      context: context,
      builder: (BuildContext context) {
        return SimpleDialog(
          children: <Widget>[
            Container(
                width: 50.0,
                height: 50.0,
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                ),
                child: new Center(child: new CircularProgressIndicator())),
          ],
        );
      }
    );
  }
}