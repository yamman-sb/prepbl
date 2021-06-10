package junit5.Supermarket;

public enum Item{
  APPLE("りんご",1,100),
  ORANGE("みかん",2,40),
  GRAPE("ぶどう",3,150),
  NORIBEN("のり弁",4,350),
  SYAKEBENN("しゃけ弁",5,400),
  TOBACCO("タバコ",6,420),
  MENTHOLTOBACCO("メンソールタバコ",7,440),
  LIGHTER("ライター",8,100),
  TEA("お茶",9,80),
  COFFEE("コーヒー",10,100);

  private final String name;
  private final int iD;
  private final int price;

  Item(String name, int iD, int price){
    this.name = name;
    this.iD = iD;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return iD;
  }

  public int getPrice() {
    return price;
  }
}