Create Random Data
------------------------
### basic information
 * command name <b>'RandomData.jar'</b>

```log
java -jar RandomData.jar
```
 * parameters
```log
-t  for type of the file
  it can be csv,excel,tab,pipe
  
-f for file name
-h for header when you want to create header with manual type
  such as -h name,age,gender,email,phone
  
-r for record
-c for columns
-l for printing extran information in console

```

# create csv file
```shell
java -jar RandomData.jar -t csv -f <file name>
```
