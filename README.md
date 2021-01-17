# SendEmailDemo
Send Email Example

## Validate email format (using regular expressions): 

```
    // Validate email format using regular expression
    private boolean isEmailValid(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
```
Also, I check that, at least, one email is written..

```
  if (!ccEmail[0].isEmpty() && isEmailValid(ccEmail[0])){
  ...
  ...
  }
```
Create an intent and startActivity:
```
  Intent intent = new Intent(Intent.ACTION_SENDTO);
  ...
  ...
  startActivity(Intent.createChooser(intent, "Choose an Email app"));
```

### Checking code for details.

## Visual result:
<p align = "center">
<img src="/images/02.png" width="250"> <img src="/images/01.png" width="250"> <img src="/images/03.png" width="250">
</p>
