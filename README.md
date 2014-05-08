StartStopActivityContiniously
=============================

DEMO for Start Stop Start Activity Continiously and quickly, we still get right activity lifecycle

Without the handler to delay handle, this is the error log:
05-08 11:55:08.706: W/test(9324): to start
05-08 11:55:08.826: E/test(9324): to stop
05-08 11:55:08.876: W/test(9324): to start
05-08 11:55:08.966: I/test(9344): com.example.testactivity.TestActivity@41c45480, onCreate
05-08 11:55:08.966: I/test(9344): com.example.testactivity.TestActivity@41c45480, processIntent, action = start  // the first start action
05-08 11:55:08.966: I/test(9344): com.example.testactivity.TestActivity@41c45480, onNewIntent
05-08 11:55:08.966: I/test(9344): com.example.testactivity.TestActivity@41c45480, processIntent, action = stop, to finish ... // the first stop action
05-08 11:55:09.026: I/test(9344): com.example.testactivity.TestActivity@41c45480, onNewIntent
05-08 11:55:09.026: I/test(9344): com.example.testactivity.TestActivity@41c45480, processIntent, action = start  // the second start action
05-08 11:55:09.656: I/test(9344): com.example.testactivity.TestActivity@41c45480, onDestroy  // according to the first stop action, but the last action is start, we need the activity to show, but the activity is destroyed, that is the problem.


After add the handler to delay handle the stop action:
05-08 12:00:17.196: W/test(9442): to start
05-08 12:00:17.346: E/test(9442): to stop
05-08 12:00:17.426: W/test(9442): to start
05-08 12:00:17.516: I/test(9465): com.example.testactivity.TestActivity@41c3f070, onCreate
05-08 12:00:17.516: I/test(9465): com.example.testactivity.TestActivity@41c3f070, processIntent, action = start
05-08 12:00:17.516: I/test(9465): com.example.testactivity.TestActivity@41c3f070, onNewIntent
05-08 12:00:17.516: I/test(9465): com.example.testactivity.TestActivity@41c3f070, processIntent, action = stop, to finish ...
05-08 12:00:17.516: I/test(9465): com.example.testactivity.TestActivity@41c3f070, onNewIntent
05-08 12:00:17.516: I/test(9465): com.example.testactivity.TestActivity@41c3f070, processIntent, action = start
// this activiy remains, that is ok.

More test(1)
05-08 12:02:21.936: W/test(9575): to start
05-08 12:02:22.046: E/test(9575): to stop
05-08 12:02:22.096: W/test(9575): to start
05-08 12:02:22.106: E/test(9575): to stop
05-08 12:02:22.116: W/test(9575): to start
05-08 12:02:22.136: E/test(9575): to stop
05-08 12:02:22.146: W/test(9575): to start
05-08 12:02:22.156: E/test(9575): to stop
05-08 12:02:22.156: W/test(9575): to start
05-08 12:02:22.166: E/test(9575): to stop
05-08 12:02:22.176: W/test(9575): to start
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onCreate
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = start
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = stop, to finish ...
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = start
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = stop, to finish ...
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = start
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = stop, to finish ...
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = start
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = stop, to finish ...
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = start
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.446: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = stop, to finish ...
05-08 12:02:22.506: I/test(9598): com.example.testactivity.TestActivity@41c437e0, onNewIntent
05-08 12:02:22.506: I/test(9598): com.example.testactivity.TestActivity@41c437e0, processIntent, action = start

More test(2)
05-08 12:03:15.496: W/test(9684): to start
05-08 12:03:15.666: E/test(9684): to stop
05-08 12:03:15.666: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onCreate
05-08 12:03:15.666: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = start
05-08 12:03:15.676: W/test(9684): to start
05-08 12:03:15.696: E/test(9684): to stop
05-08 12:03:15.696: W/test(9684): to start
05-08 12:03:15.726: E/test(9684): to stop
05-08 12:03:15.816: W/test(9684): to start
05-08 12:03:15.826: E/test(9684): to stop
05-08 12:03:15.856: W/test(9684): to start
05-08 12:03:15.856: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:15.856: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = stop, to finish ...
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = start
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = stop, to finish ...
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = start
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = stop, to finish ...
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:15.866: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = start
05-08 12:03:15.976: E/test(9684): to stop
05-08 12:03:16.006: W/test(9684): to start
05-08 12:03:16.016: E/test(9684): to stop
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = stop, to finish ...
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = start
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = stop, to finish ...
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = start
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onNewIntent
05-08 12:03:16.046: I/test(9704): com.example.testactivity.TestActivity@41c748e0, processIntent, action = stop, to finish ...
05-08 12:03:16.876: I/test(9704): com.example.testactivity.TestActivity@41c748e0, onDestroy


