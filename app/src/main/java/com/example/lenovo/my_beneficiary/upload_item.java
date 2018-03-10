package com.example.lenovo.my_beneficiary;

/**
 * Created by lenovo on 3/4/2018.
 */

class Upload_Item {
   public String person;
    public String item_name;
    public String item_description;

    public Upload_Item() {
    }

    public Upload_Item(String person, String item_name, String item_description) {
       this.person = person;
        this.item_name = item_name;
        this.item_description = item_description;
    }
    public String getPerson_name_()
    {
        return person;
    }
    public String getItem_name()
    {
        return item_name;
    }
    public String getItem_description()
    {
        return  item_description;
    }
}
