import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:one_relief/widget/Strings.dart';


class IntroLandingScreen extends StatefulWidget {
  IntroLandingScreen({Key key}) : super(key: key);

  @override
  _IntroLandingScreenState createState() => _IntroLandingScreenState();
}

class _IntroLandingScreenState extends State<IntroLandingScreen> {

  @override
  void initState() {
    super.initState();
  }

  SwiperController _controller = new SwiperController();
  int _currentIndex = 0;
  final List<String> titles = [
    "Welcome",
    "Support",
    "Fund"
  ];
  final List<String> subtitles = [
    "One Relief",
    "Number of NGO are 30",
    "Total Amount raised till date is ${StringsAll.currencySymbol}20,00,000"
  ];
  final List<Color> colors = [
    // Colors.green.shade300,
    // Colors.blue.shade300,
    // Colors.indigo.shade300,
    Color(0xFFFF9844),
    Color(0xFFFE8853),
    Color(0xFFFD7267),
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
       body: Stack(
         children: <Widget>[
           Swiper(
             loop: false,
             index: _currentIndex,
             onIndexChanged: (index){
               setState(() {
                 _currentIndex = index;
               });
             },
             controller: _controller,
             pagination: SwiperPagination(
               builder: DotSwiperPaginationBuilder(
                 activeColor: Colors.lightGreen,
                 activeSize: 20.0
               ),
             ),
             itemCount: 3,
             itemBuilder: (context, index){
               return IntroItem(
                 title: titles[index],
                 subTitle: subtitles[index],
                 bg: colors[index],
                 imageUrl: "",
               );
             },
           ),
           Align(
             alignment: Alignment.bottomLeft,
             child: FlatButton(
               child: Text("SKIP"),
               onPressed: (){
                 Navigator.pushReplacementNamed(context, 'loginscreen');
               },
             ),
           ),
           Align(
             alignment: Alignment.bottomRight,
             child: IconButton(
               icon: Icon(_currentIndex == 2 ? Icons.check : Icons.arrow_forward),
               onPressed: (){
                 if(_currentIndex != 2 ) _controller.next();
                 else Navigator.pushReplacementNamed(context, 'loginscreen');
               },
             ),
           ),
         ],
       ),
    );
  }
}

class IntroItem extends StatelessWidget{
  final String title;
  final String subTitle;
  final Color bg;
  final String imageUrl;

  IntroItem({this.title, this.subTitle, this.bg, this.imageUrl});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: bg ?? Colors.teal,
      child: SafeArea(
        child: Padding(
          padding: EdgeInsets.all(16.0),
          child: Column(
            children: <Widget>[
              SizedBox(height: 40,),
              Text(title, style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 35.0,
                color: Colors.white
              ),),
              if(subTitle != null)...[
                SizedBox(height: 20.0,),
                Text(subTitle, style: TextStyle(
                  color: Colors.white,
                  fontSize: 24.0,
                ),textAlign: TextAlign.center,),
              ],
              SizedBox(height: 40.0,),
              Expanded(
                child: Container(
                  margin: EdgeInsets.only(bottom: 70),
                  width: double.infinity,
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(20.0),
                    child: Material(
                      elevation: 4.0,
                      child: Image.asset("assets/one2.png",fit: BoxFit.cover,),
                    ),
                  ),
                ),
              ),

            ],
          ),
        ),
      ),
    );
  }
}