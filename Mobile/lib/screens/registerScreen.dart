import 'package:flutter/material.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class Register extends StatefulWidget {
  Register({Key key}) : super(key: key);

  @override
  _RegisterState createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  bool _autoValidate = false;
  final _formKey = GlobalKey<FormState>();
  final _charityNameController = TextEditingController();
  final _emailController = TextEditingController();
  final _phoneNumberController = TextEditingController();
  final _locationController = TextEditingController();
  final _registrationNumberController = TextEditingController();
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
            ),
          ],
        ),
        actions: <Widget>[],
        backgroundColor: Colors.white.withOpacity(0.8),
        automaticallyImplyLeading: false,
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
                SizedBox(
                  height: 15,
                ),
                _textFormField("Name", _charityNameController, TextInputType.text),
                SizedBox(
                  height: 15,
                ),
                _textFormField("LastName", _locationController, TextInputType.text),
                SizedBox(
                  height: 15,
                ),
                _textFormField("E-mail", _emailController, TextInputType.emailAddress),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Phone number", _phoneNumberController, TextInputType.phone),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Postcode", _registrationNumberController, TextInputType.number),
                SizedBox(
                  height: 15,
                ),
                _textFormField("Date Of Birth", _registrationNumberController, TextInputType.multiline),
                SizedBox(
                  height: 15,
                ),
                // TextFormField(
                //   decoration: InputDecoration(
                //     hintText: "Charity Description (Optional)",
                //     labelText: "Charity Description",
                //     fillColor: Colors.white,
                //     border: OutlineInputBorder(
                //       borderRadius: BorderRadius.circular(5),
                //     ),
                //   ),
                //   maxLines: 3,
                //   controller: _charityDescriptionController,
                //   autovalidate: _autoValidate,
                //   validator: (val) {
                //     if (val.length == 0) {
                //       return "This field cannot be empty";
                //     } else {
                //       return null;
                //     }
                //   },
                //   keyboardType: TextInputType.emailAddress,
                // ),
                SizedBox(
                  height: 30,
                ),
                // RaisedButton(
                //   child: Text("SUBMIT"),
                //   onPressed: (){
                //     validate();
                //   },
                // ),
                Buttons.roundedRectButton("SUBMIT", UIColors.orangeGradients, validate()),
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
