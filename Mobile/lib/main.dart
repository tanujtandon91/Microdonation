import 'package:flutter/material.dart';
import 'package:one_relief/screens/DashboardScreen.dart';
import 'package:one_relief/screens/LoginScreen.dart';
import 'package:one_relief/screens/SplashScreen.dart';
import 'package:one_relief/screens/contactus.dart';
import 'package:one_relief/screens/forgotpassword.dart';
import 'package:one_relief/screens/helpScreen.dart';
import 'package:one_relief/screens/inviteDonor.dart';
import 'package:one_relief/screens/landingScreen.dart';
import 'package:one_relief/screens/listUnderCategory.dart';
import 'package:one_relief/screens/myNGOs.dart';
import 'package:one_relief/screens/notifications.dart';
import 'package:one_relief/screens/paymentMode.dart';
import 'package:one_relief/screens/paymentType.dart';
import 'package:one_relief/screens/recurringPayment.dart';
import 'package:one_relief/screens/registerCharity.dart';
import 'package:one_relief/screens/registerScreen.dart';
import 'package:one_relief/screens/resetpassword.dart';
import 'package:one_relief/screens/settingScreen.dart';
import 'package:one_relief/screens/updateProfile.dart';
import 'package:one_relief/widget/Colors.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Daily Report App',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: UIColors.blueColor,
      ),
      home: SplashScreen(),
      routes: {
        'loginscreen' : (context) => LoginScreen(),
        'dashboard' : (context) => DashBoard(),
        'forgotpassword': (context) => ForgotPassword(),
        'resetpassword': (context) => ResetPassword(),
        'registercharity': (context) => RegisterCharity(),
        'register': (context) => Register(),
        'invitedonor': (context) => InviteDonor(),
        'settings': (context) => Settings(),
        'contactus': (context) => ContactUs(),
        'updateprofile': (context) => UpdateProfile(),
        'listcategory': (context) => ListUnderCategory(),
        'landing': (context) => IntroLandingScreen(),
        'notifications': (context) => NotificationScreen(),
        'help': (context) => HelpScreen(),
        'myngo': (context) => MyNGO(),
        'paymenttype': (context) => PaymentType(),
        'paymentmode': (context) => PaymentModeScreen(),
        'recurringpayment': (context) => RecurringPayment(),
        
      },
    );
  }
}


