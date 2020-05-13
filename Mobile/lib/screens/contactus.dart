import 'package:flutter/material.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';
import 'package:url_launcher/url_launcher.dart';

class ContactUs extends StatefulWidget {
  ContactUs({Key key}) : super(key: key);

  @override
  _ContactUsState createState() => _ContactUsState();
}

class _ContactUsState extends State<ContactUs> {
  bool _autoValidate = false;
  final _contactus_formkey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  final _emailController = TextEditingController();
  final _messageController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Contact Us"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.only(left: 10, right: 10, bottom: 20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              SizedBox(height: 20),
              // Row(
              //   mainAxisAlignment: MainAxisAlignment.center,
              //   children: <Widget>[
              //   Flexible(
              //     child: Column(
              //       crossAxisAlignment: CrossAxisAlignment.center,
              //       children: <Widget>[
              //         Text(StringsAll.contactUsByWhatsApp, style: TextStyle(fontSize: 18, ),),
              //       ],
              //     ),
              //   ),
              // ],),
              Text(StringsAll.contactUsByWhatsApp, style: TextStyle(fontSize: 18, ),),
              GestureDetector(
                child: RichText(
                  text: TextSpan(
                    text: "one_relief@gmail.com",
                    style: TextStyle(color: Colors.orange, fontSize: 22)
                  ),
                ),
                onTap: (){
                  _launchEmailApi("one_relief@gmail.com");
                },
              ),
              SizedBox(height: 30),
              Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: <Widget>[
                  Text("Or leave message for us", textAlign: TextAlign.left,),
                ],
              ),
              // _textFormField("Name", _nameController, TextInputType.text),
              // SizedBox(height: 10),
              // _textFormField("Email", _nameController, TextInputType.emailAddress),
              SizedBox(height: 10),
              new Form(
                key: _contactus_formkey,
                autovalidate: _autoValidate,
                child: TextFormField(
                    decoration: InputDecoration(
                      hintText: "Your message",
                      // labelText: "Your message",
                      fillColor: Colors.white,
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(5),
                      ),
                    ),
                    maxLines: 6,
                    controller: _nameController,
                    autovalidate: _autoValidate,
                    validator: (val) {
                      if (val.length == 0) {
                        return "This field cannot be empty";
                      } else {
                        return null;
                      }
                    },
                    keyboardType: TextInputType.text,
                  ),
              ),
                SizedBox(
                  height: 50,
                ),
                // RaisedButton(
                //   child: Container(
                //     width: double.infinity,
                //     child: Center(child: Text("Send")),
                //   ),
                //   color: Colors.blue,
                //   onPressed: (){},
                // ),
                Buttons.roundedRectButton("SEND", UIColors.orangeGradients, _sendForValidate),
            ],
          )
        )
      ),
    );
  }

  _launchEmailApi(String email) async{
    var url = 'mailto:$email';
    if (await canLaunch(url)) {
      await launch(url);
    } else {
      throw 'Could not launch $url';
    }
  }

  _sendForValidate() {
    if (_contactus_formkey.currentState.validate()) {
      _contactus_formkey.currentState.save();
      WidgetStandarts.submitAction(context);
    }
  }
}