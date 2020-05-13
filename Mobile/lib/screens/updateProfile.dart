import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:io';

import 'package:flutter/services.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class UpdateProfile extends StatefulWidget {
  UpdateProfile({Key key}) : super(key: key);

  @override
  _UpdateProfileState createState() => _UpdateProfileState();
}

class _UpdateProfileState extends State<UpdateProfile> {
  Profile _profile = Profile();
  bool _autoValidate = false;
  bool _isEnabled = true;
  static bool _isEnabled4;
  GlobalKey<FormState> _formProfileKey = new GlobalKey<FormState>();
  static File galleryFile ;
  File _selectedFile ;
  FocusNode _focusForMobile = FocusNode();
  FocusNode _focusForEmail = FocusNode();
  FocusNode _focusForAddress = FocusNode();
  bool _editOn = false;
  static Profile profile;
  TextEditingController _nameController = new TextEditingController();
  TextEditingController _emailController = new TextEditingController();
  TextEditingController _mobileController = new TextEditingController();
  TextEditingController _birthDateController = new TextEditingController();
  TextEditingController _occupationController = new TextEditingController();
  TextEditingController _cityController = new TextEditingController();
  TextEditingController _pincodeController = new TextEditingController();
  ScrollController _scrollController = new ScrollController();
  bool _load = false;
  String _errorMsg = '';
  bool imageErrorFlag = false;


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Update Profile"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
       body: profileView(_profile),
    );
  }

  Widget profileView(Profile pProfile){
    return SingleChildScrollView(controller: _scrollController,
      child: new Container(
        padding: EdgeInsets.all(17.0),
        child: new Form(
          key: _formProfileKey,
          autovalidate: _autoValidate,
          child:  new Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              new Stack(
                alignment: Alignment.bottomRight,
                children: <Widget>[

                  new CircleAvatar(
                    backgroundColor: Colors.black12,
                    // backgroundImage: galleryFile != null ? new FileImage(File(galleryFile.path)) :
                    // (((pProfile.mImgString == "") || (pProfile.mImgString == ""))
                    //     ? new AssetImage("assets/Avatar.png")
                    //     : NetworkImage('${Global.mBaseUrl}getImage?logopath=${pProfile.mImgString}') ),
                    radius: 60.0,
                    foregroundColor: Colors.transparent,
                  ),

                  Padding(
                    padding: EdgeInsets.only(left: 0, top: 0.0),
                    child: new Container(
                      child: new IconButton(
                        icon: Icon(
                          Icons.edit,
                          color: Colors.black54,
                        ),
                        onPressed: () {
                          _editOn = true;
                          // _imageSelectorGallery();
                        },
                      ),
                      decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          color: Colors.white,
                          border: Border.all(color: Colors.black12)),
                    ),
                  ),
                ],
              ),
              SizedBox(height: 30,),
              _getTextFormField('Name', 'Name *', _nameController, TextInputType.text),SizedBox(height: 10,),
              _getTextFormField('Email', 'Email *', _emailController, TextInputType.text),SizedBox(height: 10,),
              _getTextFormField('Mobile Number', 'Mobile Number *', _mobileController, TextInputType.text),SizedBox(height: 10,),
              _getTextFormField('Birth Date', 'Birth Date *', _birthDateController, TextInputType.text),SizedBox(height: 10,),
              _getTextFormField('Occupation', 'Occupation *', _occupationController, TextInputType.text),SizedBox(height: 10,),
              _getTextFormField('City', 'City *', _cityController, TextInputType.text),SizedBox(height: 10,),
              _getTextFormField('Pincode', 'Pincode *', _pincodeController, TextInputType.text),
              SizedBox(height: 30,),
              Buttons.roundedRectButton('SUBMIT', UIColors.orangeGradients, _sendForValidate),
            ],
          ),
        ),
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

  Future<void> _callDialoge() async {
    String returnVal = await showDialog(
        barrierDismissible: false,
        context: context,
        // builder: (_) =>  new DialogClass(pProfile: profile)
    );
    if((returnVal != null) && (returnVal.toLowerCase() == 'success')) {

      Timer(Duration(milliseconds: 0), () => _scrollController.jumpTo(_scrollController.position.minScrollExtent));
      setState(() {
        _editOn = false;
        _isEnabled4 = false;
      });
      _focusForMobile.unfocus();
      _focusForEmail.unfocus();
      _focusForAddress.unfocus();
    }
  }

  _sendForValidate() {
    if (_formProfileKey.currentState.validate()) {
      _formProfileKey.currentState.save();
      WidgetStandarts.submitAction(context);
      // _callDialoge();
    }
  }

  // _imageSelectorGallery() async {
  //   _selectedFile = await ImagePicker.pickImage(source: ImageSource.gallery);
  //   int imageSize = (_selectedFile.lengthSync() / (1024 * 1024)).round();
  //   if(imageSize <= 1){
  //     setState((){
  //       galleryFile = _selectedFile;
  //       imageErrorFlag = false;
  //     });
  //   }else{
  //     setState((){
  //       imageErrorFlag = true;
  //       _selectedFile = null;
  //     });
  //   }
  // }
}

class Profile{
  String name;
  String email;
  int mobileNumber;
  String yearOfBirth;
  String occupation;
  String city;
  int pincode;

  Profile({this.name, this.email, this.mobileNumber});
}