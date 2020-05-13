import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:one_relief/screens/charityInfo.dart';
import 'package:one_relief/widget/Buttons.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class RecurringPayment extends StatefulWidget {
  @override
  _RecurringPaymentState createState() => _RecurringPaymentState();
}

class _RecurringPaymentState extends State<RecurringPayment> {
  final _recurrngPayment_formkey = GlobalKey<FormState>();
  int _sDate = 0;
  int _eDate = 0;
  final _startDateController = TextEditingController();
  final _endDateController = TextEditingController();
  String firstDropValue = "ONE";
  String secondDropValue = 'YEAR';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Recurring Payment"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
        padding: EdgeInsets.fromLTRB(20, 10, 0, 20),
        child: ListView(children: <Widget>[
          Center(child: Text("Payment Schedule",
            style: TextStyle(
              fontSize: 22,
              fontWeight: FontWeight.bold,
              color: UIColors.black45Color
            ),
          ),
        ),
        SizedBox(height: 20,),
        Text("Recurring",
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.bold,
          ),
        ),
        SizedBox(height: 10,),
        Container(
          width: double.infinity,
          child: Row(
            children: <Widget>[
              Expanded(
                flex: 5,
                child: DropdownButton(
                  hint: Text('Start Date *  '), // Not necessary for Option 1
                  value: firstDropValue,
                  onChanged: (newValue) {
                    setState(() {
                      firstDropValue = newValue;
                    });
                  },
                  items: ['ONE', 'TWO', 'EVERY'].map((value) {
                    return DropdownMenuItem(
                      child: Text(value),
                      value: value,
                    );
                  }).toList(),
                ),
              ),
              SizedBox(width: 40),
              Expanded(
                flex: 5,
                child: DropdownButton(
                  hint: Text('End Date *  '), // Not necessary for Option 1
                  value: secondDropValue,
                  onChanged: (newValue) {
                    setState(() {
                      secondDropValue = newValue;
                    });
                  },
                  items: ['YEAR', 'MONTH', 'WEEK'].map((value) {
                    return DropdownMenuItem(
                      child: Text(value),
                      value: value,
                    );
                  }).toList(),
                ),
              ),
            ],
          ),
        ),
        SizedBox(height: 20,),
        Text("Date",
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.bold,
          ),
        ),
        Container(
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
              SizedBox(width: 10),
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
        SizedBox(height: 20,),
        
        Text("Renewal Payment Retry: In 12 hours",
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.bold,
          ),
        ),
        SizedBox(height: 40.0,),
        Center(child: Buttons.roundedRectButton("Pay Now", UIColors.signUpGradients, validate),),
        // Center(child: GestureDetector(
        //   child: 
        //   onTap: (){
        //     // Fluttertoast.showToast(msg: "Pay Later");
        //   },
        // )),
       ],),
    ),
    );
  }

  validate(){
    Fluttertoast.showToast(msg: "Pay Later");
    // if(_recurrngPayment_formkey.currentState.validate()){
    //   _recurrngPayment_formkey.currentState.save();
    //   WidgetStandarts.submitAction(context);
    // }
  }

  listTile(String label){
    return Container(
      decoration: BoxDecoration(
        border: Border(bottom: BorderSide()),
      ),
      child: ListTile(
        title: Text(label),
      ),
    );
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