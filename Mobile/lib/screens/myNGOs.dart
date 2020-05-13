import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:one_relief/screens/charityInfo.dart';
import 'package:one_relief/screens/listUnderCategory.dart';
import 'package:one_relief/widget/Colors.dart';
import 'package:one_relief/widget/Strings.dart';
import 'package:one_relief/widget/WidgetStandarts.dart';

class MyNGO extends StatefulWidget {
  String categoryItem;
  MyNGO({this.categoryItem});

  @override
  _MyNGOState createState() => _MyNGOState();
}

class _MyNGOState extends State<MyNGO> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("My NGO"),
        flexibleSpace: Container(
          decoration: WidgetStandarts.getHeaderDecoration()
        ),
      ),
      body: Container(
      padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
       child: ListView(children: <Widget>[
         GestureDetector(
          child: categoryCard('Orphan Donation', 5, 5000),
          onTap: (){
            Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Orphan Donation")));
          },
        ),
        GestureDetector(
          child: categoryCard('Women Empowerment', 6, 8000),
          onTap: (){
            Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Women Empowerment")));
          },
        ),
        GestureDetector(
          child: categoryCard('Homeless', 4, 20000),
          onTap: (){
            Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Homeless")));
          },
        ),
        GestureDetector(
          child: categoryCard('Blue Water', 4, 7000),
          onTap: (){
            Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Blue Water")));
          },
        ),
        GestureDetector(
          child: categoryCard('Cancer Donation', 4, 7000),
          onTap: (){
            Navigator.push(context, MaterialPageRoute(builder: (context) => ListUnderCategory(categoryItem: "Cancer Donation")));
          },
        ),
       ],),
    ),
    );
  }

  Widget listTile(String title, String subTitle){
    return ListTile(
      leading: CircleAvatar(
        child: Text('${title.substring(0,1)}', style: TextStyle(fontWeight: FontWeight.bold),),
        backgroundColor: UIColors.orangeColor,
      ),
      trailing: Text('${StringsAll.currencySymbol}5000'),
      title: Text(title),
      subtitle: Text(subTitle),
    );
  }

  Widget categoryCard(String name, int totalNGO, int totalDonation){
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
              height: 110,
              margin: EdgeInsets.symmetric(vertical: 10.0),
              padding:  EdgeInsets.symmetric(vertical: 10.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: <Widget>[
                  Container(
                    width: 50,
                    height: 50,
                    margin: EdgeInsets.only(right: 15),
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(50),
                      border: Border.all(width: 3, color: Color(0xFFF29A94)),
                      image: DecorationImage(
                        image: CachedNetworkImageProvider(
                          'https://www.humanitygives.com/wp-content/uploads/2017/08/orphan-appeal-charities-in-uk.jpg'
                        ),
                        fit: BoxFit.fill
                      ),
                    ),
                  ),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Text(name, style: TextStyle(color: Color(0xFF696B9E), fontWeight: FontWeight.bold, fontSize: 18),),
                        SizedBox(height: 6,),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: <Widget>[
                            Text('Total Added NGOs', style: TextStyle(color: Color(0xFF696B9E), fontSize: 16, letterSpacing: .3),),
                            Text(totalNGO.toString(),style: TextStyle(color: Color(0xFF696B9E), fontSize: 16),),
                          ],
                        ),
                        SizedBox(height: 6,),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: <Widget>[
                            Text('Total Amount Donated', style: TextStyle(color: Color(0xFF696B9E), fontSize: 16, letterSpacing: .3),),
                            Text('${StringsAll.currencySymbol}${totalDonation.toString()}',style: TextStyle(color: Color(0xFF696B9E), fontSize: 16),),
                          ],
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}