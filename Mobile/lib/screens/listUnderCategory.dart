import 'package:flutter/material.dart';
import 'package:one_relief/screens/charityInfo.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class ListUnderCategory extends StatefulWidget {
  String categoryItem;
  ListUnderCategory({this.categoryItem});

  @override
  _ListUnderCategoryState createState() => _ListUnderCategoryState();
}

class _ListUnderCategoryState extends State<ListUnderCategory> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('${widget.categoryItem}'),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
      padding: EdgeInsets.fromLTRB(0, 10, 0, 20),
       child: ListView(children: <Widget>[
         Container(
           child: Padding(
             padding: EdgeInsets.symmetric(horizontal: 10),
             child: Material(
               elevation: 5,
               borderRadius: BorderRadius.all(Radius.circular(30)),
               child: TextField(
                 decoration: InputDecoration(
                   hintText: 'Search NGO',
                   border: InputBorder.none,
                   prefixIcon: Material(
                     child: Icon(Icons.search),
                     borderRadius: BorderRadius.all(Radius.circular(30)),
                   ),
                   contentPadding: EdgeInsets.symmetric(horizontal: 25,vertical: 13),
                 ),
               ),
             ),
           ),
         ),
         SizedBox(height: 20,),
         GestureDetector(
            child: listTile('Bhagini Nivedita Pratishthan Pune', 'Sadashiv Peth Pune'),
            onTap: (){
              Navigator.push(context, MaterialPageRoute(builder: (context) => CharityInfoScreen(charityname: "Bhagini Nivedita Pratishthan Pune",)));
            },
         ),
         GestureDetector(
            child: listTile('Community Aid & Sponsorship Programme (CASP)', 'Pashan, Pune'),
            onTap: (){
              Navigator.push(context, MaterialPageRoute(builder: (context) => CharityInfoScreen(charityname: "Community Aid & Sponsorship Programme (CASP)",)));
            },
         ),
         GestureDetector(
            child: listTile('IDEA Foundation', 'Mayur Colony , Kothrud Pune'),
            onTap: (){
              Navigator.push(context, MaterialPageRoute(builder: (context) => CharityInfoScreen(charityname: "IDEA Foundation",)));
            },
         ),
         GestureDetector(
            child: listTile('Social Action for Manpower Creation', 'Talegaon Dabhade, Pune'),
            onTap: (){
              Navigator.push(context, MaterialPageRoute(builder: (context) => CharityInfoScreen(charityname: "Social Action for Manpower Creation",)));
            },
         ),
         GestureDetector(
            child: listTile('Janaseva Foundation', 'Indulal Complex, 1st floor Above Rupee Bank L.B.S. Road, Navi Peth'),
            onTap: (){
              Navigator.push(context, MaterialPageRoute(builder: (context) => CharityInfoScreen(charityname: "Janaseva Foundation",)));
            },
         ),
         
         
         
         
       ],),
    ),
    );
  }

  Widget listTile(String title, String subTitle){
    return ListTile(
      leading: CircleAvatar(child: Text('A'),backgroundColor: UIColors.orangeColor,),
      trailing: Text('${StringsAll.currencySymbol}5000'),
      title: Text(title),
      subtitle: Text(subTitle),
    );
  }
}