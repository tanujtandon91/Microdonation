import 'package:flutter/material.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class ForgotPassword extends StatefulWidget {
  ForgotPassword({Key key}) : super(key: key);
  @override
  _ForgotPasswordState createState() => _ForgotPasswordState();
}

class _ForgotPasswordState extends State<ForgotPassword> {
  final _forgot_formkey = GlobalKey<FormState>();
  final _userNameController = TextEditingController();
  bool _autoValidate = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Forgot Password"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
        padding: EdgeInsets.all(20),
        child: Column(children: <Widget>[
          // TextFormField(
          //   controller: _userNameController,
          //   // onSaved: (val) => widget.marketMonitor.setPrice(val),
          //   keyboardType: TextInputType.text,
          //   validator: (String value) {
          //     if (value.isEmpty || (value.trim()).length == 0) {
          //       return 'This field cannot be empty';
          //     }
          //     return null;
          //   },
          //   decoration: InputDecoration(
          //     labelText: 'E-mail *',
          //     enabledBorder: const OutlineInputBorder(
          //       borderSide: const BorderSide(color: Color(0xFFFF9844), width: 0.0),
          //     ),
          //   ),
          // ),
          Form(
            key: _forgot_formkey,
            autovalidate: _autoValidate,
            child: TextFormField(
              decoration: InputDecoration(
                hintText: 'E-mail',
                labelText: 'E-mail *',
                fillColor: Colors.white,
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(5),
                ),
              ),
              controller: _userNameController,
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
          SizedBox(height: 30,),
          // Buttons.getButton("Submit", UIColors.blueAccentColor, forgotPassword),
          Buttons.roundedRectButton('SUBMIT', UIColors.orangeGradients, _sendForValidate),
        ],),
      ),
    );
  }

  forgotPassword(){
    setState(() {
      WidgetStandarts.loderDialog(context);
    });
    // var response = ApiCalls.forgotPassword(_userNameController.text);
    // response.then((result){
    //   Navigator.pop(context);
    //   if(result.isCorrect && result.status == "success"){
    //     // WidgetStandarts.submitAction(context);
    //     Fluttertoast.showToast(msg: "New password has been sent to your registered email address at ${result.data.email}", toastLength: Toast.LENGTH_SHORT);
    //     Navigator.pushNamed(context, 'loginscreen');
    //   }else{
    //     Fluttertoast.showToast(msg: result.error, toastLength: Toast.LENGTH_SHORT);
    //   }
    // });
  }

  _sendForValidate() {
    if (_forgot_formkey.currentState.validate()) {
      _forgot_formkey.currentState.save();
      WidgetStandarts.submitAction(context);
    }
  }
}