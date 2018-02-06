const electron = require('electron')
// Module to control application life.
const app = electron.app
// Module to create native browser window.
const BrowserWindow = electron.BrowserWindow

const path = require('path')
const url = require('url')
//require ipcMain
const {ipcMain} = require("electron")
// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let mainWindow

function createWindow () {
  // Create the browser window.
  mainWindow = new BrowserWindow({width: 800, height: 600, frame: false})

  // and load the index.html of the app.
  mainWindow.loadURL(url.format({
    pathname: path.join(__dirname, '/index.html'),
    protocol: 'file:',
    slashes: true
  }))

  console.log(process.versions);
  var java = require("java");
  // java.classpath.push("commons-lang3-3.1.jar");
  // java.classpath.push("commons-io.jar");
  var jar_path = "ROLL.jar"
  java.classpath.push(jar_path);
  console.log(jar_path);
  var ROLL = java.newInstanceSync("cn.ac.ios.roll.ROLL");
  var args = java.newArray("java.lang.String", [])
  var res = java.callMethod(ROLL,"main",args,function(err, results) {
      var c = console;
      if(err) { console.error(err); return; }
      // results from doSomething
      c.log("haha");
  });

  // console.log(res);

  console.log("ok");
  // Open the DevTools.
  mainWindow.webContents.openDevTools()

  // Emitted when the window is closed.
  mainWindow.on('closed', function () {
    // Dereference the window object, usually you would store windows
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.
    mainWindow = null
  })
}

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.on('ready', createWindow)

// Quit when all windows are closed.
app.on('window-all-closed', function () {
  // On OS X it is common for applications and their menu bar
  // to stay active until the user quits explicitly with Cmd + Q
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

app.on('activate', function () {
  // On OS X it's common to re-create a window in the app when the
  // dock icon is clicked and there are no other windows open.
  if (mainWindow === null) {
    createWindow()
  }
})

// In this file you can include the rest of your app's specific main process
// code. You can also put them in separate files and require them here.


//return message for MQ box
var MQ = "Connection built";
//return message for EQ box 
var EQ = "Connection built";
var JSOreturn = "{\"MQ\":\""+MQ+"\",\"EQ\":\""+EQ+"\"}";
var alphabet="";
ipcMain.on("alphabetSubmit",function(event,arg){
   alphabet = arg;
    event.sender.send("callback",JSOreturn);
});

ipcMain.on("MQY",function(event,arg){
    event.sender.send("callback",JSOreturn);
});

ipcMain.on("MQN",function(event,arg){
    event.sender.send("callback",JSOreturn);
});

ipcMain.on("EQY",function(event,arg){
    event.sender.send("callback",JSOreturn);
});

ipcMain.on("EQN",function(event,arg){
    event.sender.send("callback",JSOreturn);
});

ipcMain.on("autoRun",function(event,arg){
    var code = arg;
    var output = "Connection built";
    event.sender.send("autoback",output);
});
