class ResponseModel {
  Data data;
  String status;
  int statusCode;
  bool isCorrect;
  String message;
  String error;

  ResponseModel();

  ResponseModel.fromJson(Map<String, dynamic> json) {
    data = json['data'] != null ? new Data.fromJson(json['data']) : null;
    status = json['status'];
    error = json['error'];
  }

  String get getMessage => message;
  bool get getIsCorrect => isCorrect;

  void setMessage(String msg){
    message = msg;
  }

  void setIsCorrect(bool correctflag){
    isCorrect = correctflag;
  }

  void setData(Data pData){
    data = pData;
  }
}

class Data{ 
  Data.fromJson(String json);
}