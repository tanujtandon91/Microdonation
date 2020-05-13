import 'package:flutter/material.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class CharityInfoScreen extends StatefulWidget {
  String charityname;
  CharityInfoScreen({this.charityname});

  @override
  _CharityInfoScreenState createState() => _CharityInfoScreenState();
}

class _CharityInfoScreenState extends State<CharityInfoScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("${widget.charityname}"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Container(
              height: 300,
              width: double.infinity,
              child: Image.asset('assets/bhagini.png'),
            ),
            Padding(
              padding: EdgeInsets.only(left: 16, right: 16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Row(
                    children: <Widget>[
                      Expanded(child: Text("EST : Oct 21, 2017"),),
                      IconButton(icon: Icon(Icons.share), onPressed: (){},)
                    ],
                  ),
                  Text("${widget.charityname}", style: TextStyle(fontSize: 20),),
                  Divider(),
                  SizedBox(height: 10.0,),
                  Text(StringsAll.bhaginiNividita, style: TextStyle(),textAlign: TextAlign.justify,),
                  SizedBox(height: 40.0,),
                  Center(child: Buttons.roundedRectButton("Donate Now", UIColors.signUpGradients, navigate)),
                  // Center(child: GestureDetector(
                  //   child: Buttons.roundedRectButton("Donate Now", UIColors.signUpGradients, navigate),
                  //   onTap: (){
                      
                  //   },
                  // )),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  navigate(){
    return Navigator.pushNamed(context, 'paymenttype');
  }
}