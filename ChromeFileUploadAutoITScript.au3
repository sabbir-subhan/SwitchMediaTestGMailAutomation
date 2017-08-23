#include <MsgBoxConstants.au3>
WinWait('Open')
WinActivate('Open')
Sleep(1000)
ControlSetText("Open","","[CLASS:Edit; INSTANCE:1]","C:\Users\Public\Pictures\Sample Pictures\appiumwithjava.png")
Sleep(1000)
ControlClick("Open","","[CLASS:Button;INSTANCE:1]")
Sleep(1000)