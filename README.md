# Alpine Bank
This is an Android app for the ficticious Alpine Bank. It is an implementation of the coding challenge for Manulife Financial, which is outlined at https://github.com/seyDoggy/ml-app-challenge

## Features
1. View your current accounts and their corresponding balances
2. See transactions for any account grouped by date

## Build Instructions
1. Clone this repo to your local computer
2. Open the project in a recent version of Android Studio
3. Build the source code via "Build -> Make Project" menu option
4. Create an Android Virtual Device or connect an Android phone running at least Android 5.0 (Lollipop)
6. Choose "Run -> Run app" menu option to deploy the app to your chosen device

## Usage Instructions
1. Press the OPEN button on the splash screen
2. View your accounts and their balances
3. You have the option to quit the app with the QUIT button in the top right corner. This will close your app session and display the splash screen next time you open the app.
4. Press an account to view the transactions associated with the account, grouped by date in reverse chronological order

## Plugins Used
### SectionedRecyclerViewAdapter
This is a library to extend the Android `RecyclerViewAdapter` to support sectioned data within a `RecyclerView`. More info: https://github.com/luizgrp/SectionedRecyclerViewAdapter

I used this library because I wanted to group the transactions of an account by date. This grouping makes it easy to quickly parse transactions, particularly if you're looking for a transaction you made on a specific date.
