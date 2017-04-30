RucksackSolver
====================================

LogCleanClient is a project to solve the rucksack problem with dynamic programming and as well with the FPTAS.
The project was written and tested in Java.

[![Build status](https://ci.appveyor.com/api/projects/status/3rpj4680ki73l3ab?svg=true)](https://ci.appveyor.com/project/SeppPenner/rucksacksolver-java)


## How does the configuration need to look like:
```xml
<?xml version="1.0" encoding="utf-8"?>
<Config xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
	<RucksackObjects>
		<RucksackObject>
			<Price>232</Price>
			<Weight>153</Weight>
		</RucksackObject>
		<RucksackObject>
			<Price>73</Price>
			<Weight>54</Weight>
		</RucksackObject>
		<RucksackObject>
			<Price>201</Price>
			<Weight>191</Weight>
		</RucksackObject>
		<RucksackObject>
			<Price>50</Price>
			<Weight>66</Weight>
		</RucksackObject>
	</RucksackObjects>
</Config>
```

## Screenshot from the project:
![Screenshot from the project](https://github.com/SeppPenner/RucksackSolver-Java/blob/master/Screenshot.PNG "Screenshot from the project")

Change history
--------------

* **Version 1.0.0.0 (2017-04-30)** : 1.0 release.