import 'package:flutter/material.dart';
import 'package:one_relief/screens/listUnderCategory.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';
import 'package:cached_network_image/cached_network_image.dart';
import 'package:share/share.dart';


class DashBoard extends StatefulWidget {
  DashBoard({Key key}) : super(key: key);

  @override
  _DashBoardState createState() => _DashBoardState();
}

class _DashBoardState extends State<DashBoard> with SingleTickerProviderStateMixin{
  final GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey<ScaffoldState>();
  int _sDate = 0;
  int _eDate = 0;
  final _startDateController = TextEditingController();
  final _endDateController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    print(MediaQuery.of(context).size);
    return Scaffold(
      key: _scaffoldKey,
      drawer: getDrawer(context),
      appBar: AppBar(
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
        title: Text('DashBoard'),
        leading: new IconButton(
          icon: new Icon(Icons.dehaze),
          onPressed: () => _scaffoldKey.currentState.openDrawer(),
        ),
        actions: <Widget>[
          Padding(
            padding: EdgeInsets.only(right: 5),
            child: IconButton(icon: Icon(Icons.notifications), onPressed: (){
              Navigator.pushNamed(context, 'notifications');
            }),
          ),
        ],
        automaticallyImplyLeading: false,
      ),
      body: _buildBody(),
      bottomNavigationBar: WidgetStandarts.getBottomBar(true, context, 0),
    );
  }

  _buildBody(){
    return Container(
      child: ListView(
        scrollDirection: Axis.vertical,
        children: <Widget>[
          Center(
            child: Container(
              height: 125,
              child: Center(
                child: ListView(
                  scrollDirection: Axis.horizontal,
                  shrinkWrap: true,
                  children: <Widget>[
                    topCards("550000","Lifetime", Colors.blue),
                    topCards("150000","Current Year", Colors.pink),
                    topCards("50000","Current Month", Colors.green),
                  ],
                ),
              ),
            ),
          ),
          Container(
            padding: EdgeInsets.fromLTRB(16, 16, 16, 5),
            child: Text(" Select date range to view payment details.",style: TextStyle(fontWeight: FontWeight.bold),),
          ),
          Container(
            padding: EdgeInsets.all(16),
            width: double.infinity,
            child: Row(
              children: <Widget>[
                Expanded(
                  flex: 5,
                  child: InkWell(
                    onTap: () {
                      _selectDate();   // Call Function that has showDatePicker()
                    },
                    child: IgnorePointer(
                      child: Container(
                        width: 110.0,
                        child: new TextFormField(
                          decoration: new InputDecoration(
                              labelText: 'Start Date*',
                              suffixIcon: Icon(Icons.calendar_today, color: Colors.blue, size: 20,)
                          ),
                          // autovalidate: _autoValidate,
                          validator: (dt){
                            if(dt == null || dt.isEmpty){
                              return 'This field cannot be empty';
                            }
                            return null;
                          },
                          controller: _startDateController,
                        ),
                      ),
                    ),
                  ),
                ),
                SizedBox(width: 10,),
                Expanded(
                  flex: 5,
                  child: InkWell(
                    onTap: () {
                      _selectDate2();
                    },
                    child: IgnorePointer(
                      child: Container(
                        width: 110.0,
                        child: new TextFormField(
                          decoration: new InputDecoration(labelText: 'End Date*',suffixIcon: Icon(Icons.calendar_today, color: Colors.blue,size: 20,)),
                          // autovalidate: _autoValidate,
                          validator: (dt){
                            if(dt == null || dt.isEmpty){
                              return 'This field cannot be empty';
                            }
                            return null;
                          },
                          controller: _endDateController,
                        ),
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
          Column(children: <Widget>[
            GestureDetector(
              child: categoryCard('Bhagini Nivedita Pratistan', "1,23,000", "23/03/2020", "UPI Payment", "23:00"),
              onTap: (){
                // Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Orphan Donation")));
              },
            ),
            GestureDetector(
              child: categoryCard('Orphan Donation NGO', "1,23,000", "02/03/2020", "Net Banking", "21:00"),
              onTap: (){
                // Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Orphan Donation")));
              },
            ),
            GestureDetector(
              child: categoryCard('Women Empowerment NGO, Pune', "73,000", "17/02/2020", "Credit Card", "19:00"),
              onTap: (){
                // Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Women Empowerment")));
              },
            ),
            GestureDetector(
              child: categoryCard('Homeless NGO, Pune', "83,000", "27/01/2020", "Debit Card", "17:00"),
              onTap: (){
                // Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Homeless")));
              },
            ),
            GestureDetector(
              child: categoryCard('Blue Water NGO', "1,20,000", "23/12/2019", "Saved Card", "20:00"),
              onTap: (){
                // Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Blue Water")));
              },
            ),
            GestureDetector(
              child: categoryCard('Cancer Donation', "1,00,000", "03/12/2019", "UPI Payment", "12:00"),
              onTap: (){
                // Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Cancer Donation")));
              },
            ),
          ],),
        ],
      ),
    );
  }

  Widget categoryCard(String name, String totalAmount, String date, String paymentMode, String time){
    return Padding(
      padding: EdgeInsets.fromLTRB(16, 2, 16, 1),
      child: Container(
        child: Column(
          children: <Widget>[
            Container(
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(25),
                color: Colors.white
              ),
              width: double.infinity,
              height: MediaQuery.of(context).size.height * 0.41,
              margin: EdgeInsets.symmetric(vertical: 10.0),
              padding:  EdgeInsets.symmetric(vertical: 10.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  rowOfTransactionCard("Date", date),
                  SizedBox(height: 5,),
                  rowOfTransactionCard("Time", time),
                  SizedBox(height: 5,),
                  rowOfTransactionCard("NGO", name),
                  SizedBox(height: 5,),
                  rowOfTransactionCard("Mode Of Payment", paymentMode),
                  SizedBox(height: 5,),
                  rowOfTransactionCard("Amount Contributed", totalAmount),
                  SizedBox(height: 5,),
                  rowOfTransactionCard("Amount passed to NGO", totalAmount),
                  SizedBox(height: 5,),
                  rowOfTransactionCard("Date paid to NGO", date),
                  SizedBox(height: 5,),
                  rowOfTransactionCard("Notes","Data is confidential"),
                  SizedBox(height: 5,),
                  Divider(thickness: 1, color: UIColors.orangeColor,),
                  Row(
                    children: <Widget>[
                      bottomOfTransactionCard("LifeTime", "1,00,000"),
                      bottomOfTransactionCard("Current Year", "50,000"),
                      bottomOfTransactionCard("Current Month", "20,000"),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  getDrawer(BuildContext context){
    return Drawer(
      child: ListView(
        children: <Widget>[
          DrawerHeader(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                CircleAvatar(
                radius: 40,
                child: FittedBox(
                  child: Icon(Icons.account_circle, size: 110,),
                ),
                ),
                SizedBox(height: 10),
                Text("OneRelief"),
              ],
            ),
            decoration: BoxDecoration(
              gradient: LinearGradient(
                colors: UIColors.orangeGradients
              ),
            ),
          ),
          // drawerTile("Invite Donor", "invitedonor", Icons.group),
          // drawerTile("My NGO", "myngo", Icons.select_all),
          // drawerTile("Register Charity", "registercharity", Icons.edit),
          drawerTile("Settings", "settings", Icons.settings),
          // drawerTile("Update Profile", "updateprofile", Icons.account_circle),
          drawerTile("Reset Password", "resetpassword", Icons.settings_backup_restore),
          drawerTile("Contact Us", "contactus", Icons.phone),
          drawerTile("Help", "help", Icons.help),
          ListTile(
            title: Text("Share"),
            trailing: Icon(Icons.share),
            onTap: (){
              final RenderBox box = context.findRenderObject();
              Share.share("text",
                          subject: "subject",
                          sharePositionOrigin:
                              box.localToGlobal(Offset.zero) &
                                  box.size);
            },
          ),
          ListTile(
            title: Text("Logout"),
            trailing: Icon(Icons.launch),
            onTap: (){
              logout();
            },
          ),
        ],
      ),
    );
  }

  topCards(String value, String label, Color color){
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Container(
        width: 200,
        padding: EdgeInsets.all(8.0),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(10.0),
          color: color,
        ),
        child: Column(
          children: <Widget>[
            Text("${StringsAll.currencySymbol}$value", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white),),
            const SizedBox(height: 15.0,),
            Text(label.toUpperCase(),style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white),),
          ],
        ),
      ),
    );
  }

  rowOfTransactionCard(String label, String value){
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: <Widget>[
        Text(label, style: TextStyle(color: Color(0xFF696B9E),fontWeight: FontWeight.bold),),
        Text(value,style: TextStyle(color: Color(0xFF696B9E)),),
      ],
    );
  }

  bottomOfTransactionCard(String label, String value){
    return Expanded(
      child: Column(
        children: <Widget>[
          Text(label, style: TextStyle(color: Color(0xFF696B9E),fontWeight: FontWeight.bold),),
          Text("${StringsAll.currencySymbol}$value", style: TextStyle(color: Color(0xFF696B9E)),),
        ],
      ),
    );
  }

  drawerTile(String label, String navigatorString, IconData icon){
    return ListTile(
      title: Text(label),
      trailing: Icon(icon),
      onTap: (){
        Navigator.of(context).pop();
        Navigator.pushNamed(context, navigatorString);
      },
    );
  }

  void logout()async{
    Navigator.of(context).pushNamedAndRemoveUntil('loginscreen', (Route<dynamic> route) => false);
  }

  Future<Null> _selectDate() async {
    DateTime mNow = DateTime.now();
    final DateTime selectedStatrtDate = await showDatePicker(
        context: context,
        initialDate: _sDate == 0 ? DateTime(mNow.year, mNow.month, mNow.day).subtract(new Duration(days: 30)) : DateTime.fromMillisecondsSinceEpoch(_sDate),
        firstDate: DateTime(2000),
        lastDate: _eDate == 0 ? DateTime(mNow.year, mNow.month, mNow.day) : DateTime.fromMillisecondsSinceEpoch(_eDate),
    );
    if (selectedStatrtDate != null){
      _startDateController.text = StringsAll.dateFormat.format(selectedStatrtDate);
      _sDate =  selectedStatrtDate.millisecondsSinceEpoch;
    }
  }

  Future<Null> _selectDate2() async {
    DateTime mNow = DateTime.now();
    final DateTime selectedEndDate = await showDatePicker(
        context: context,
        initialDate: _eDate == 0 ? DateTime(mNow.year, mNow.month, mNow.day) : DateTime.fromMillisecondsSinceEpoch(_eDate),
        firstDate: _sDate == 0 ? DateTime(mNow.year, mNow.month, (mNow.day)) : DateTime.fromMillisecondsSinceEpoch(_sDate),
        lastDate: DateTime(mNow.year, mNow.month, mNow.day),
    );
    if (selectedEndDate != null){
      _endDateController.text = StringsAll.dateFormat.format(selectedEndDate);
      _eDate =  selectedEndDate.millisecondsSinceEpoch;
    }
  }
}