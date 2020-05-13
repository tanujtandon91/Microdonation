import 'package:flutter/material.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

import 'package:one_relief/screens/contacts_dialog.dart';
import 'package:contacts_service/contacts_service.dart';
import 'package:flutter/services.dart';
import 'package:permission_handler/permission_handler.dart';

class InviteDonor extends StatefulWidget {
  InviteDonor({Key key}) : super(key: key);

  @override
  _InviteDonorState createState() => _InviteDonorState();
}

class _InviteDonorState extends State<InviteDonor> {
  bool _autoValidate = false;
  final _inviteDonor_formkey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  final _emailAddressController = TextEditingController();
  final _mobileNumberController = TextEditingController();
  Iterable<Contact> _contacts;
  Contact _actualContact;

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Invite Donor",
        ),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
        backgroundColor: Colors.white.withOpacity(0.8),
      ),
      body: bodyWidget(),
    );
  }

  Widget bodyWidget(){
    return SingleChildScrollView(
        child: Form(
          key: _inviteDonor_formkey,
          autovalidate: _autoValidate,
          child: Container(
            padding: EdgeInsets.all(20),
            child: Center(
              child: Column(
                children: <Widget>[
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: "Name",
                      labelText: "Name *",
                      fillColor: Colors.white,
                      suffixIcon: IconButton(
                        icon: Icon(Icons.contact_phone),
                        onPressed: (){
                          _showContactList(context);
                        }
                      ),
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(5),
                      ),
                    ),
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
                  SizedBox(height: 10,),
                  // _textFormField("Name", "Name *", _nameController, TextInputType.text),
                  _textFormField("Email", "Email *", _emailAddressController, TextInputType.text),
                  SizedBox(height: 10,),
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: "Mobile",
                      labelText: "Mobile *",
                      fillColor: Colors.white,
                      suffixIcon: IconButton(
                        icon: Icon(Icons.contact_phone),
                        onPressed: (){
                          _showContactList(context);
                        }
                      ),
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(5),
                      ),
                    ),
                    controller: _mobileNumberController,
                    autovalidate: _autoValidate,
                    validator: (val) {
                      if (val.length == 0) {
                        return "This field cannot be empty";
                      } else {
                        return null;
                      }
                    },
                    keyboardType: TextInputType.phone,
                  ),
                  // _textFormField("Mobile", "Mobile *", _mobileNumberController, TextInputType.text),
                  SizedBox(height: 40),
                  Buttons.roundedRectButton("SUBMIT", UIColors.orangeGradients, validate),
                ],
              ),
            ),
          ),
        ),
      );
  }

  validate(){
    if(_inviteDonor_formkey.currentState.validate()){
      _inviteDonor_formkey.currentState.save();
      WidgetStandarts.submitAction(context);
    }
  }

  TextFormField _textFormField1(String hintText, TextEditingController _controller, IconData icon, TextInputType keyboardType) {
    return TextFormField(
      
      decoration: InputDecoration(
        hintText: hintText,
        labelText: hintText,
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(30),
        ),
        prefixIcon: Icon(icon),
        // enabledBorder: UnderlineInputBorder(      
        //   borderSide: BorderSide(color: Colors.orange),   
        // ),  
        focusedBorder: OutlineInputBorder(      
          borderSide: BorderSide(color: Colors.orange),
          borderRadius: BorderRadius.circular(30),
        ),  
      ),
      controller: _controller,
      autovalidate: _autoValidate,
      validator: (val) {
        if(val.length==0) {
          return "This field cannot be empty";
        }else{
          return null;
        }
      },
      keyboardType: keyboardType,
    );
  }

  TextFormField _textFormField(
      String hintText, String labelText, TextEditingController _controller, TextInputType keyboardType) {
    return TextFormField(
      decoration: InputDecoration(
        hintText: hintText,
        labelText: labelText,
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

  RawMaterialButton _buildSelectContactButton(IconData iconButton, Color colorButton) {
    return RawMaterialButton(
      constraints: const BoxConstraints(
          minWidth: 40.0, minHeight: 40.0
      ),
      onPressed: () => {
        _showContactList(context)

      },
      child: Icon(
        // Conditional expression:
        // show "favorite" icon or "favorite border" icon depending on widget.inFavorites:
        iconButton,
        color: Theme.of(context).primaryColorLight,
      ),
      elevation: 0.5,
      fillColor: colorButton,
      shape: CircleBorder(),
    );



  }
  // Getting list of contacts from AGENDA
  refreshContacts() async {
    PermissionStatus permissionStatus = await _getContactPermission();
    if (permissionStatus == PermissionStatus.granted) {
      var contacts = await ContactsService.getContacts();
      setState(() {
        _contacts = contacts;
      });
    } else {
      _handleInvalidPermissions(permissionStatus);
    }
  }

  // Asking Contact permissions
  Future<PermissionStatus> _getContactPermission() async {
    PermissionStatus permission = await PermissionHandler().checkPermissionStatus(PermissionGroup.contacts);
    if (permission != PermissionStatus.granted && permission != PermissionStatus.disabled) {
      Map<PermissionGroup, PermissionStatus> permissionStatus = await PermissionHandler().requestPermissions([PermissionGroup.contacts]);
      return permissionStatus[PermissionGroup.contacts] ?? PermissionStatus.unknown;
    } else {
      return permission;
    }
  }

  // Managing error when you don't have permissions
  void _handleInvalidPermissions(PermissionStatus permissionStatus) {
    if (permissionStatus == PermissionStatus.denied) {
      throw new PlatformException(
          code: "PERMISSION_DENIED",
          message: "Access to location data denied",
          details: null);
    } else if (permissionStatus == PermissionStatus.disabled) {
      throw new PlatformException(
          code: "PERMISSION_DISABLED",
          message: "Location data is not available on device",
          details: null);
    }
  }

  // Showing contact list.
  Future<Null> _showContactList(BuildContext context) async {
    List<Contact> favoriteElements = [];
    final InputDecoration searchDecoration = const InputDecoration();

    refreshContacts();
    if (_contacts != null)
    {
      showDialog(
        context: context,
        builder: (_) =>
            SelectionDialogContacts(
              _contacts.toList(),
              favoriteElements,
              showCountryOnly: false,
              emptySearchBuilder: null,
              searchDecoration: searchDecoration,
            ),
      ).then((e) {
        if (e != null) {
          setState(() {
            _actualContact = e;
          });
          _nameController.text = _actualContact.displayName;
          _emailAddressController.text = _actualContact.emails.first.value;
          _mobileNumberController.text = _actualContact.phones.first.value;
        }
      });
    }
  }
}