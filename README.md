### Sample project for Stackoverflow question Is it possible to register all classes within a package as Spring beans

On Unix run
```
gradlew bootRun
```

On Windows run
```
gradlew.bat bootRun
```
----
Go to <http://localhost:8080> to see the list of all beans (including those which were created at runtime)

----

```javascript
[
  "application",
  "mainController",
  . . .
  "Square_Bean",
  "Triangle_Bean",
  "Circle_Bean",
  "Oval_Bean"
]
```
