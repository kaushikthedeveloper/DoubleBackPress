# DoubleBackPress : Android Library

The module is in the extremely painful process of being completely remodeled. As always, thank you for your patience.

**In case of extreme emergency to try out the module ;-) , download the [First commit's Snapshot](
https://github.com/kaushikthedeveloper/DoubleBackPress/tree/634d3b242240b81e8006e1afc677f8a1c1ba4b6e) of the project and refer to 
the example code to get workings!**

## About

### Usage

The library provides double back press functionality, i.e., actions taken upon clicking of back button twice in short 
(custom predefined) interval of time.

### Main Functionalities

1. Action to be performed upon double click of back button
2. Action to be performed upon single click of back button, before the double click occurs
3. Standard responses after first back button click provided

## Documentation

### Index

- [DoubleBackPress](#DoubleBackPress)
    - Constructor
        - [withDoublePressDuration](#withDoublePressDuration)
        - [withDoubleBackPressAction](#withDoubleBackPressAction)
        - [withFirstBackPressAction](#withFirstBackPressAction)
    - Methods
        - [setDoublePressDuration](#setDoublePressDuration)
        - [setDoubleBackPressAction](#setDoubleBackPressAction)
        - [setFirstBackPressAction](#setFirstBackPressAction)

- [DoubleBackPressAction](#DoubleBackPressAction)

- [FirstBackPressAction](#FirstBackPressAction)

- [ToastDisplay](#ToastDisplay)
    - constructor
        - [standard](#ToastDisplayStandard)

- [SnackbarDisplay](#SnackbarDisplay)
    - constructor
        - [standard](#SnackbarDisplayStandard)


---

1. <a name="DoubleBackPress"></a>Setup DoubleBackPress

    ```java
    DoubleBackPress doubleBackPress = new DoubleBackPress()
                .withDoublePressDuration(...)           //required
                .withDoubleBackPressAction(...)         //required
                .withFirstBackPressAction(...);         //optional
    ```

    or

    ```java
    DoubleBackPress doubleBackPress = new DoubleBackPress(doublePressDuration, doubleBackPressAction)   //required
                .withFirstBackPressAction(...);                                                         //optional
    ```

    or
    
    ```java
    DoubleBackPress doubleBackPress = new DoubleBackPress();
    doubleBackPress.set...(...);                       //setter methods
    ```

    Put the behaviour of the DoubleBackPress as the desired behaviour upon back button click.

    ```java
    @Override
    public void onBackPressed() {
        doubleBackPress.onBackPressed();
    }
    ```

---

2. Setting the environment using `with...` methods for the DoubleBackPress constructor.

    - <a name="withDoublePressDuration"></a>Set the duration within which the 2nd back press needs to occur to be considered a Double Back Press.

        **REQUIRED**

        ```java
        .withDoublePressDuration(int doublePressDuration)
        ```

        **Parameters :**
        - `doublePressDuration` : int
            => msec duration period, within which the back press should occur again to be counted as a DoubleBackPress

        **Returns :**
        - `DoubleBackPress`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `doublePressDuration` is not set

        ---

    - <a name="withDoubleBackPressAction"></a>Set the action to be performed after the DoubleBackPress occurs.

        **REQUIRED**

        ```java
        .withDoubleBackPressAction(DoubleBackPressAction doubleBackPressAction)
        ```

        **Parameters :**
        - `doubleBackPressAction` : DoubleBackPressAction
            => The action that should be performed after DoubleBackPress

        **Returns :**
        - `DoubleBackPress`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `doubleBackPressAction` is not set

        ---

    - <a name="withFirstBackPressAction"></a>Set the action to be performed after the first back press occurs, before the 2nd back press.

        **OPTIONAL**

        ```java
        .withFirstBackPressAction(FirstBackPressAction firstBackPressAction)
        ```

        **Parameters :**
        - `firstBackPressAction` : FirstBackPressAction
            => The action that should be performed after the first back button click, before the 2nd back press.

        **Returns :**
        - `DoubleBackPress`

---

3. Setting the environment using `set...` methods for the DoubleBackPress object.

    - <a name="setDoublePressDuration"></a>Set the duration within which the 2nd back press needs to occur to be considered a Double Back Press.

        **REQUIRED**

        ```java
        .setDoublePressDuration(int doublePressDuration)
        ```

        **Parameters :**
        - `doublePressDuration` : int
            => msec duration period, within which the back press should occur again to be counted as a DoubleBackPress

        **Returns :**
        - `void`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `doublePressDuration` is not set

        ---

    - <a name="setDoubleBackPressAction"></a>Set the action to be performed after the DoubleBackPress occurs.

        **REQUIRED**

        ```java
        .setDoubleBackPressAction(DoubleBackPressAction doubleBackPressAction)
        ```

        **Parameters :**
        - `doubleBackPressAction` : DoubleBackPressAction
            => The action that should be performed after DoubleBackPress

        **Returns :**
        - `void`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `doubleBackPressAction` is not set

        ---

    - <a name="setFirstBackPressAction"></a>Set the action to be performed after the first back press occurs, before the 2nd back press.

        **OPTIONAL**

        ```java
        .setFirstBackPressAction(FirstBackPressAction firstBackPressAction)
        ```

        **Parameters :**
        - `firstBackPressAction` : FirstBackPressAction
            => The action that should be performed after the first back button click, before the 2nd back press.

        **Returns :**
        - `void`

---

4. <a name="DoubleBackPressAction"></a>Create object of `DoubleBackPressAction`

    Passed in :

    ```java
    .withDoubleBackPressAction(DoubleBackPressAction)
    ```

    Override the `actionCall()` method when creating the Object. This method is called when the 2nd back press occurs.

    Below is an example where after the DoubleBackPress, the Activity calls its original `onBackPressed()` method.

    ```java
    DoubleBackPressAction doubleBackPressAction = new DoubleBackPressAction() {
        @Override
        public void actionCall() {
            ExampleActivity.super.onBackPressed();
        }
    };
    ```

---

5. <a name="FirstBackPressAction"></a>Create object of `FirstBackPressAction`

    Passed in :

    ```java
    .withFirstBackPressAction(FirstBackPressAction)
    ```

    Override the `actionCall()` method when creating the Object. This method is called when the first back press occurs.

    Below is an example where after the first back button press, the Activity shows a Toast to the user.

    ```java
    FirstBackPressAction firstBackPressAction = new FirstBackPressAction() {
        @Override
        public void actionCall() {
            Toast.makeText(ExampleActivity.this, "Press back again to Exit", Toast.LENGTH_SHORT).show();
        }
    };
    ```

---

6. Standard displays after the first action to be shown to the user:

    - <a name="ToastDisplay"></a>`ToastDisplay` : standard Toast

        Example to show toast for `Toast.LENGTH_SHORT` period of time upon the first back button press, with a message reading 
        "Press back button to confirm".

        ```java
        FirstBackPressAction firstBackPressAction = new ToastDisplay()
                    .standard(this);                                        //required

        DoubleBackPress doubleBackPress = new DoubleBackPress()
                    .withFirstBackPressAction(firstBackPressAction)
                    ...
        ```

        Example to show toast for `Toast.LENGTH_SHORT` period of time upon the first back button press, with a message reading 
        "Press back button to Exit".

        ```java
        FirstBackPressAction firstBackPressAction = new ToastDisplay()
                    .standard(this, "Press back button to Exit");            //required

        DoubleBackPress doubleBackPress = new DoubleBackPress()
                    .withFirstBackPressAction(firstBackPressAction)
                    ...
        ```
        
    - <a name="SnackbarDisplay"></a>`SnackbarDisplay` : standard Snackbar

        ***Note : Since Snackbar require the callers's parent view, the SnackbarDisplay class needs to be set and provided to the 
        DoubleBackPress object after the View is set. Example, in an Activity, this would be inside the onCreate() function, 
        after the setContentView() function is called.***

        Example to show snackbar for `Snackbar.LENGTH_SHORT` period of time upon the first back button press, with a message 
        reading "Press back button to confirm".

        ```java
        //after the view is initialized
        FirstBackPressAction firstBackPressAction = new Snackbar()
                    .standard(parentView);                                        //required

        doubleBackPress.setFirstBackPressAction(firstBackPressAction)
        ```

        Example to show snackbar for `Snackbar.LENGTH_SHORT` period of time upon the first back button press, with a message reading 
        "Press back button to Exit".

        ```java
        //after the view is initialized
        FirstBackPressAction firstBackPressAction = new Snackbar()
                    .standard(parentView, "Press back button to Exit");            //required

        doubleBackPress.setFirstBackPressAction(firstBackPressAction)
        ```

---

7. <a name="ToastDisplayStandard"></a>Options provided for the ToastDisplay constructor :

    - Set the context for the Toast

        ```java
        .standard(Context context)
        ```

        **Parameters :**
        - `context` : Context
            => Set the Context for the Toast to be displayed

        **Returns :**
        - `ToastDisplay`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `context` is not set

        ---

    - Set the context and the message for the Toast

        ```java
        .standard(Context context, String message)
        ```

        **Parameters :**
        - `context` : Context
            => Set the Context for the Toast to be displayed

        - `message` : String
            => Set the message to be displayed in the Toast

        **Returns :**
        - `ToastDisplay`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `context` is not set

---

8. <a name="SnackbarDisplayStandard"></a>Options provided for the SnackbarDisplay constructor :

    ***Note again : The standard method needs to be called after the view is created.***

    - Set the parent view for the Toast

        ```java
        .standard(View parentView)
        ```

        **Parameters :**
        - `parentView` : View
            => Set the Parent View for the Snackbar to be displayed

        **Returns :**
        - `SnackbarDisplay`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `parentView` is not set
        - `GeneralException` : if the `parentView` was passed to the SnackbarDisplay before it was created

        ---

    - Set the parent view and the message for the Toast

        ```java
        .standard(View parentView, String message)
        ```

        **Parameters :**
        - `parentView` : View
            => Set the Parent View for the Snackbar to be displayed

        - `message` : String
            => Set the message to be displayed in the Snackbar

        **Returns :**
        - `SnackbarDisplay`

        **Exceptions possible later if not called :**
        - `RequirementsNotMetException` : if the `parentView` is not set
        - `GeneralException` : if the `parentView` was passed to the SnackbarDisplay before it was created

---