import 'package:flutter/material.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class ResetPassword extends StatefulWidget {
  ResetPassword({Key key}) : super(key: key);

  @override
  _ResetPasswordState createState() => _ResetPasswordState();
}

class _ResetPasswordState extends State<ResetPassword> {
  final _currentPasswordController = TextEditingController();
  final _newPasswordController = TextEditingController();
  final _confirmPasswordController = TextEditingController();
  final _formKey = GlobalKey<FormState>();
  bool _autoValidate = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Reset Password"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: 
      ListView(
        children: <Widget>[
          Form(
            key: _formKey,
            autovalidate: _autoValidate,
            child: Container(
              padding: EdgeInsets.all(20),
              child: Column(children: <Widget>[
                _getTextFormField("Enter Current Password","Enter Current Password *", _currentPasswordController, TextInputType.text),
                SizedBox(height: 10,),
                _getTextFormField("Enter New Password","Enter New Password *", _newPasswordController, TextInputType.text),
                SizedBox(height: 10,),
                _getTextFormField("Confirm Password","Confirm Password *", _confirmPasswordController, TextInputType.text),
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
                SizedBox(height: 80,),
                // Buttons.getButton("Submit", UIColors.blueAccentColor, forgotPassword),
                GestureDetector(
                  child: Buttons.roundedRectButton('SUBMIT', UIColors.orangeGradients, _sendForValidate),
                  onTap: (){
                    if(_formKey.currentState.validate()){
                      WidgetStandarts.submitAction(context);
                    }
                  },
                ),
              ],),
            ),
          ),
        ]
      ),
      
    );
  }

  TextFormField _getTextFormField(String hintText, String labelText, 
                                  TextEditingController controller, TextInputType textInputType){
    return TextFormField(
      decoration: InputDecoration(
        hintText: hintText,
        labelText: labelText,
        fillColor: Colors.white,
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(5),
        ),
      ),
      controller: controller,
      autovalidate: _autoValidate,
      validator: (val) {
        if (val.length == 0) {
          return "This field cannot be empty";
        } else {
          return null;
        }
      },
      keyboardType: textInputType,
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
    if (_formKey.currentState.validate()) {
      _formKey.currentState.save();
      WidgetStandarts.submitAction(context);
    }
  }
}