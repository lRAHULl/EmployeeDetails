class test {
    public static void main(String[] args) {
        String[] fields = {"id", "name", "password", "age", "phone", "address", "salary", "role"};

        String placeField = "(";
        for (int i = 1; i < fields.length; i++) {
            if (i == fields.length - 1)
                placeField += fields[i];
            else
                placeField += fields[i] + ",";
        }
        placeField += ")";

        String valueField = "(";
        for (int i = 1; i < fields.length; i++) {
            if (i == fields.length - 1)
                valueField += "'" + "user" + "'";
            else
                valueField += "'" + "user" + "',";
        }
        valueField += ")";

        String str = "INSERT INTO users " + placeField + " VALUES " + valueField + ";";

        System.out.println(str);
    }
}