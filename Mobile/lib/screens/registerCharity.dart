import 'package:flutter/material.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class RegisterCharity extends StatefulWidget {
  RegisterCharity({Key key}) : super(key: key);

  @override
  _RegisterCharityState createState() => _RegisterCharityState();
}

class _RegisterCharityState extends State<RegisterCharity> {
  bool _autoValidate = false;
  final _formKey = GlobalKey<FormState>();
  final _charityNameController = TextEditingController();
  final _causeController = TextEditingController();
  final _addressController = TextEditingController();
  final _cityController = TextEditingController();
  final _pincodeController = TextEditingController();
  final _emailController = TextEditingController();
  final _mobileController = TextEditingController();
  final _phoneNumberController = TextEditingController();
  final _websiteController = TextEditingController();
  final _contactPersonController = TextEditingController();
  final _charityDescriptionController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
        title: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            // new IconButton(
            //   icon: new Icon(
            //     Icons.dehaze,
            //     color: Colors.black,
            //   ),
            //   onPressed: () {},
            // ),
            // new IconButton(
            //   icon: new Icon(
            //     Icons.account_circle,
            //     color: Colors.black,
            //   ),
            //   onPressed: () {},
            // ),
            Expanded(
              child: Text(
                "Register",
              ),
            )
          ],
        ),
        actions: <Widget>[],
        backgroundColor: Colors.white.withOpacity(0.8),
      ),
      body: bodyWidget(),
    );
  }

  Widget bodyWidget() {
    return SingleChildScrollView(
      child: Form(
        key: _formKey,
        autovalidate: _autoValidate,
        child: Container(
          padding: EdgeInsets.all(20),
          child: Center(
            child: Column(
              children: <Widget>[
                Text("Register Charity",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 35,
                    )),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Name of Charity", _charityNameController, TextInputType.text),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Cause", _causeController, TextInputType.text),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Address of Charity", _addressController, TextInputType.text),
                SizedBox(
                  height: 15,
                ),
                _textFormField("City", _cityController, TextInputType.text),
                SizedBox(
                  height: 15,
                ),
                _textFormField("PIN code", _pincodeController, TextInputType.number),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Email", _emailController, TextInputType.emailAddress),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Mobile", _mobileController, TextInputType.phone),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Phone", _phoneNumberController, TextInputType.phone),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Website", _websiteController, TextInputType.emailAddress),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Contact Person", _contactPersonController, TextInputType.text),
                SizedBox(
                  height: 15,
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: "Description of Charity",
                    labelText: "Description of Charity",
                    fillColor: Colors.white,
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(5),
                    ),
                  ),
                  maxLines: 3,
                  controller: _charityDescriptionController,
                  autovalidate: _autoValidate,
                  validator: (val) {
                    if (val.length == 0) {
                      return "This field cannot be empty";
                    } else {
                      return null;
                    }
                  },
                  keyboardType: TextInputType.emailAddress,
                ),
                SizedBox(
                  height: 30,
                ),
                // RaisedButton(
                //   child: Text("SUBMIT"),
                //   onPressed: (){
                //     validate();
                //   },
                // ),
                Buttons.roundedRectButton("SUBMIT", UIColors.orangeGradients, validate),
              ],
            ),
          ),
        ),
      ),
    );
  }

  validate(){
    if(_formKey.currentState.validate()){
      _formKey.currentState.save();
      WidgetStandarts.submitAction(context);
    }
  }

  TextFormField _textFormField(
      String hintText, TextEditingController _controller, TextInputType keyboardType) {
    return TextFormField(
      decoration: InputDecoration(
        hintText: hintText,
        labelText: hintText,
        fillColor: Colors.white,
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(5),
        ),
      ),
      controller: _controller,
      autovalidate: _autoValidate,
      validator: (val) {
        if (val.length == 0) {
          return "This field cannot be empty";
        } else {
          return null;
        }
      },
      keyboardType: keyboardType,
    );
  }
}
