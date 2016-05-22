## Definitions
### Error
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|localizedMessage||false|string||
|cause||false|Throwable||
|stackTrace||false|Array||
|suppressed||false|Array||
|message||false|string||


### Flight
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|fltNumber||false|string||
|airlineCode||false|string||
|engineType||false|string||
|seats||false|int||


### Map[String,Object]
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|empty||false|boolean||


### ModelAndView
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|reference||false|boolean||
|view||false|View||
|viewName||false|string||
|modelMap||false|ModelMap||
|model||false|Map[String,Object]||
|empty||false|boolean||


### ModelMap
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|empty||false|boolean||


### SearchResponse
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|error||false|Error||
|flights||false|List||


### StackTraceElement
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|fileName||false|string||
|nativeMethod||false|boolean||
|methodName||false|string||
|className||false|string||
|lineNumber||false|int||


### Throwable
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|localizedMessage||false|string||
|cause||false|Throwable||
|stackTrace||false|Array||
|suppressed||false|Array||
|message||false|string||


### View
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|contentType||false|string||


