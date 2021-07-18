#Boot
A library for executing operations only once

## Usage
### Basic usage
1. initialize the library:
```
    Boot.init(context)
```
or
```
    initBoot(context)
```
2. register an operation:
```
    executeOnce("operation_mark") {
        //do something only once
    }
```
### Do something if the operation is already executed
```
    executeOnce("operation_mark") {
        //do something only once
    }.alreadyExecuted {
        //do something else if the main operation is already executed
    }
```
### Check if the operation is executed
```
    Boot.isExecuted("operation_mark")
```
### Get all the registered operations
```
    Boot.getAllOperations()
```