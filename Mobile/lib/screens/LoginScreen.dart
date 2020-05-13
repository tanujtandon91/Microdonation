import 'package:flutter/material.dart';
import 'package:one_relief/widget/Colors.dart';

class LoginScreen extends StatefulWidget {
  LoginScreen({Key key}) : super(key: key);

  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  
  @override
  Widget build(BuildContext context) {
  return Scaffold(
    resizeToAvoidBottomPadding: false,
    backgroundColor: Colors.white,
    body: Stack(
      children: <Widget>[
        Background(),
        Login(),
      ],
    ));
  }
}

class Background extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomPadding: false,
      backgroundColor: Colors.white,
      body: Column(
        children: <Widget>[
          new Stack(
            alignment: Alignment.bottomCenter,
            children: <Widget>[
              WavyHeader(),
              Image.asset('assets/one2.png', width: MediaQuery.of(context).size.width/1.5,),
            ],
          ),
        ],
      ),
    );
  }
}

class WavyHeader extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ClipPath(
      child: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(
              colors: UIColors.orangeGradients,
              begin: Alignment.topLeft,
              end: Alignment.center,
              ),
        ),
        height: MediaQuery.of(context).size.height / 2.5,
      ),
    );
  }
}

class Login extends StatelessWidget {
  bool _showPass = true;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        Padding(
          padding:
              EdgeInsets.only(top: MediaQuery.of(context).size.height / 2.5),
        ),
        Column(
          children: <Widget>[
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Stack(
                  alignment: Alignment.bottomRight,
                  children: <Widget>[
                    // InputWidget(30.0, 0.0),
                    Padding(
                      padding: EdgeInsets.only(right: 40, bottom: 30),
                      child: Container(
                        width: MediaQuery.of(context).size.width - 40,
                        child: Material(
                          elevation: 10,
                          color: Colors.white,
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.only(
                                  bottomRight: Radius.circular(30),
                                  topRight: Radius.circular(00))),
                          child: Padding(
                            padding: EdgeInsets.only(left: 40, right: 20, top: 10, bottom: 10),
                            child: Column(children: <Widget>[
                              TextFormField(
                                decoration: InputDecoration(
                                  border: InputBorder.none,
                                  hintText: "username",
                                  hintStyle: TextStyle(color: Color(0xFFE1E1E1), fontSize: 14),
                                ),
                                onSaved: (value){

                                },
                              ),
                              Divider(),
                              TextFormField(
                                decoration: InputDecoration(
                                  border: InputBorder.none,
                                  hintText: "Password",
                                  hintStyle: TextStyle(color: Color(0xFFE1E1E1), fontSize: 14),
                                  suffixIcon: IconButton(
                                    icon: Icon(Icons.remove_red_eye,color: _showPass ? UIColors.black12Color : UIColors.blueColor,),
                                    onPressed: () {
                                      // setState(() {
                                        _showPass = !_showPass;
                                      // });
                                    },
                                  ),
                                ),
                                obscureText: _showPass,
                                onSaved: (value){},
                              ),
                            ],)
                          ),
                        ),
                      ),
                    ),
                    Padding(
                        padding: EdgeInsets.only(right: 50),
                        child: Row(
                          children: <Widget>[
                            Expanded(
                                child: Padding(
                              padding: EdgeInsets.only(top: 40),
                              child: Text(
                                'Enter username and passowrd to login...',
                                textAlign: TextAlign.end,
                                style: TextStyle(color: Color(0xFFA0A0A0),
                                fontSize: 12),
                              ),
                            )),
                            Container(
                              padding: EdgeInsets.all(10),
                              decoration: ShapeDecoration(
                                shape: CircleBorder(),
                                gradient: LinearGradient(
                                    colors: UIColors.orangeGradients,
                                    begin: Alignment.topLeft,
                                    end: Alignment.bottomRight),
                              ),
                              child: GestureDetector(
                                child: ImageIcon(
                                  AssetImage("assets/ic_forward.png"),
                                  size: 40,
                                  color: Colors.white,
                                ),
                                onTap: (){
                                  Navigator.pushNamed(context, 'dashboard');
                                },
                              ),
                            ),
                          ],
                        ))
                  ],
                ),
              ],
            ),
            Padding(
              padding: EdgeInsets.only(bottom: 50),
            ),
            Padding(
              padding: EdgeInsets.only(right: 20),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  GestureDetector(
                    child: Text('Forgot Password', 
                      textAlign: TextAlign.center,
                      style: TextStyle(color: Color(0xFFFF9844)),
                    ),
                    onTap: (){
                      Navigator.pushNamed(context, 'forgotpassword');
                    },
                  ),
                ],
              ),
            ),
            SizedBox(height: 20,),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
              GestureDetector(
                child: roundedRectButton("Register", UIColors.orangeGradients, false),
                onTap: (){
                  Navigator.pushNamed(context, 'register');
                },
              ),
              // roundedRectButton("Create an Account", signUpGradients, false),
            ],)
          ],
        )
      ],
    );
  }
}

Widget roundedRectButton(String title, List<Color> gradient, bool isEndIconVisible) {
  return Builder(builder: (BuildContext mContext) {
    return Padding(
      padding: EdgeInsets.only(bottom: 10),
      child: Stack(
        alignment: Alignment(1.0, 0.0),
        children: <Widget>[
          Container(
            alignment: Alignment.center,
            width: MediaQuery.of(mContext).size.width / 2,
            decoration: ShapeDecoration(
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(30.0)),
              gradient: LinearGradient(
                  colors: gradient,
                  begin: Alignment.topLeft,
                  end: Alignment.bottomRight),
            ),
            child: Text(title,
                style: TextStyle(
                    color: Colors.white,
                    fontSize: 18,
                    fontWeight: FontWeight.w500)),
            padding: EdgeInsets.only(top: 16, bottom: 16),
          ),
          Visibility(
            visible: isEndIconVisible,
            child: Padding(
                padding: EdgeInsets.only(right: 10),
                child: ImageIcon(
                  AssetImage("assets/ic_forward.png"),
                  size: 30,
                  color: Colors.white,
                )),
          ),
        ],
      ),
    );
  });
}