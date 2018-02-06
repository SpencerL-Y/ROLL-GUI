# From electron-quick-start to ROLL

**Clone and run for a quick way to see Electron in action.**

This is a minimal Electron application based on the [Quick Start Guide](http://electron.atom.io/docs/tutorial/quick-start) within the Electron documentation.

**Use this app along with the [Electron API Demos](http://electron.atom.io/#get-started) app for API code examples to help you get started.**

A basic Electron application needs just these files:

- `package.json` - Points to the app's main file and lists its details and dependencies.
- `main.js` - Starts the app and creates a browser window to render HTML. This is the app's **main process**.
- `index.html` - A web page to render. This is the app's **renderer process**.

You can learn more about each of these components within the [Quick Start Guide](http://electron.atom.io/docs/tutorial/quick-start).

## To Use

To clone and run this repository you'll need [Git](https://git-scm.com) and [Node.js](https://nodejs.org/en/download/) (which comes with [npm](http://npmjs.com)) installed on your computer. From your command line:

```bash
# Clone this repository
git clone https://github.com/electron/electron-quick-start
# Go into the repository
cd electron-quick-start
# Install dependencies
npm install
# Run the app
npm start
```
Learn more about Electron and its API in the [documentation](http://electron.atom.io/docs/).

## Other Example Apps

For more example apps, see the
[list of boilerplates](http://electron.atom.io/community/#boilerplates)
created by the awesome electron community.

#### License [CC0 1.0 (Public Domain)](LICENSE.md)


##Integrate Java

引用 `node-java`（不是 tutorial，是我自己操作的过程，直接从 terminal 粘贴过来的）

```bash
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:15]
└─[$] <git:(master*)> l
total 112
drwxr-xr-x   17 lijianlin  staff   578B Mar 14 19:14 .
drwxr-xr-x   52 lijianlin  staff   1.7K Mar 13 23:37 ..
-rw-r--r--@   1 lijianlin  staff   8.0K Mar 14 19:13 .DS_Store
drwxr-xr-x   11 lijianlin  staff   374B Mar 14 19:15 .git
-rw-r--r--@   1 lijianlin  staff    12B Mar 11 19:33 .gitignore
-rw-r--r--    1 lijianlin  staff   6.4K Mar 11 19:04 LICENSE.md
-rw-r--r--    1 lijianlin  staff   1.6K Mar 11 19:04 README.md
drwxr-xr-x@  11 lijianlin  staff   374B Feb 26 22:20 css
drwxr-xr-x@   8 lijianlin  staff   272B Feb 26 22:20 fonts
-rwxr-xr-x@   1 lijianlin  staff    11K Mar 12 21:15 index.html
drwxr-xr-x@  12 lijianlin  staff   408B Feb 26 22:20 js
-rw-r--r--    1 lijianlin  staff   2.2K Mar 14 19:15 main.js
drwxr-xr-x  150 lijianlin  staff   5.0K Mar 14 16:39 node_modules
-rw-r--r--    1 lijianlin  staff   434B Mar 11 19:04 package.json
drwxr-xr-x@   4 lijianlin  staff   136B Mar 11 19:33 plugins
-rw-r--r--    1 lijianlin  staff   171B Mar 11 19:04 renderer.js
-rw-r--r--    1 lijianlin  staff   1.9K Mar 13 23:45 untitled.jar
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:15]
└─[$] <git:(master*)> cat package.json 
{
  "name": "electron-quick-start",
  "version": "1.0.0",
  "description": "A minimal Electron application",
  "main": "main.js",
  "scripts": {
    "start": "electron ."
  },
  "repository": "https://github.com/electron/electron-quick-start",
  "keywords": [
    "Electron",
    "quick",
    "start",
    "tutorial",
    "demo"
  ],
  "author": "GitHub",
  "license": "CC0-1.0",
  "devDependencies": {
    "electron": "^1.4.1"
  }
}
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:15]
└─[$] <git:(master*)> npm install java --save-dev

> java@0.8.0 install /Users/lijianlin/Projects/ROLL-GUI/node_modules/java
> node-gyp rebuild

gyp WARN download NVM_NODEJS_ORG_MIRROR is deprecated and will be removed in node-gyp v4, please use NODEJS_ORG_MIRROR
gyp WARN download NVM_NODEJS_ORG_MIRROR is deprecated and will be removed in node-gyp v4, please use NODEJS_ORG_MIRROR
gyp WARN download NVM_NODEJS_ORG_MIRROR is deprecated and will be removed in node-gyp v4, please use NODEJS_ORG_MIRROR
  CXX(target) Release/obj.target/nodejavabridge_bindings/src/java.o
../src/java.cpp:897:40: warning: 'ToNumber' is deprecated [-Wdeprecated-declarations]
  v8::Local<v8::Number> val = info[0]->ToNumber();
                                       ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8406:22: note: 'ToNumber' has been explicitly marked deprecated here
Local<Number> Value::ToNumber() const {
                     ^
../src/java.cpp:927:40: warning: 'ToNumber' is deprecated [-Wdeprecated-declarations]
  v8::Local<v8::Number> val = info[0]->ToNumber();
                                       ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8406:22: note: 'ToNumber' has been explicitly marked deprecated here
Local<Number> Value::ToNumber() const {
                     ^
../src/java.cpp:956:40: warning: 'ToNumber' is deprecated [-Wdeprecated-declarations]
  v8::Local<v8::Number> val = info[0]->ToNumber();
                                       ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8406:22: note: 'ToNumber' has been explicitly marked deprecated here
Local<Number> Value::ToNumber() const {
                     ^
../src/java.cpp:983:42: warning: 'ToNumber' is deprecated [-Wdeprecated-declarations]
    v8::Local<v8::Number> val = info[0]->ToNumber();
                                         ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8406:22: note: 'ToNumber' has been explicitly marked deprecated here
Local<Number> Value::ToNumber() const {
                     ^
../src/java.cpp:1019:40: warning: 'ToNumber' is deprecated [-Wdeprecated-declarations]
  v8::Local<v8::Number> val = info[0]->ToNumber();
                                       ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8406:22: note: 'ToNumber' has been explicitly marked deprecated here
Local<Number> Value::ToNumber() const {
                     ^
../src/java.cpp:1044:40: warning: 'ToNumber' is deprecated [-Wdeprecated-declarations]
  v8::Local<v8::Number> val = info[0]->ToNumber();
                                       ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8406:22: note: 'ToNumber' has been explicitly marked deprecated here
Local<Number> Value::ToNumber() const {
                     ^
../src/java.cpp:1263:16: warning: 'TryCatch' is deprecated [-Wdeprecated-declarations]
  v8::TryCatch tryCatch;
               ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:7015:40: note: 'TryCatch' has been explicitly marked deprecated here
  V8_DEPRECATED("Use isolate version", TryCatch());
                                       ^
7 warnings generated.
  CXX(target) Release/obj.target/nodejavabridge_bindings/src/javaObject.o
../src/javaObject.cpp:116:47: warning: 'NewInstance' is deprecated [-Wdeprecated-declarations]
  v8::Local<v8::Object> javaObjectObj = ctor->NewInstance();
                                              ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:3292:52: note: 'NewInstance' has been explicitly marked deprecated here
  V8_DEPRECATED("Use maybe version", Local<Object> NewInstance() const);
                                                   ^
../src/javaObject.cpp:349:47: warning: 'NewInstance' is deprecated [-Wdeprecated-declarations]
  v8::Local<v8::Object> javaObjectObj = ctor->NewInstance();
                                              ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:3292:52: note: 'NewInstance' has been explicitly marked deprecated here
  V8_DEPRECATED("Use maybe version", Local<Object> NewInstance() const);
                                                   ^
2 warnings generated.
  CXX(target) Release/obj.target/nodejavabridge_bindings/src/javaScope.o
  CXX(target) Release/obj.target/nodejavabridge_bindings/src/methodCallBaton.o
  CXX(target) Release/obj.target/nodejavabridge_bindings/src/nodeJavaBridge.o
  CXX(target) Release/obj.target/nodejavabridge_bindings/src/utils.o
../src/utils.cpp:347:21: warning: 'ToInt32' is deprecated [-Wdeprecated-declarations]
    jint val = arg->ToInt32()->Value();
                    ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8442:21: note: 'ToInt32' has been explicitly marked deprecated here
Local<Int32> Value::ToInt32() const {
                    ^
../src/utils.cpp:354:24: warning: 'ToNumber' is deprecated [-Wdeprecated-declarations]
    jdouble val = arg->ToNumber()->Value();
                       ^
/Users/lijianlin/.node-gyp/7.4.0/include/node/v8.h:8406:22: note: 'ToNumber' has been explicitly marked deprecated here
Local<Number> Value::ToNumber() const {
                     ^
2 warnings generated.
  SOLINK_MODULE(target) Release/nodejavabridge_bindings.node

> java@0.8.0 postinstall /Users/lijianlin/Projects/ROLL-GUI/node_modules/java
> node postInstall.js

electron-quick-start@1.0.0 /Users/lijianlin/Projects/ROLL-GUI
└─┬ java@0.8.0 
  ├── async@2.0.1 
  ├─┬ find-java-home@0.1.3 
  │ └── which@1.0.9 
  ├── lodash@4.16.4 
  └── nan@2.4.0 

┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:16]
└─[$] <git:(master*)>  2555  npm i electron-rebuild --save-dev
zsh: command not found: 2555
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:17]
└─[$] <git:(master*)> npm install electron-rebuild --save-dev
npm WARN prefer global node-gyp@3.5.0 should be installed with -g
electron-quick-start@1.0.0 /Users/lijianlin/Projects/ROLL-GUI
└─┬ electron-rebuild@1.5.7 
  ├─┬ babel-register@6.24.0 
  │ ├─┬ babel-core@6.24.0 
  │ │ ├─┬ babel-code-frame@6.22.0 
  │ │ │ ├── esutils@2.0.2 
  │ │ │ └── js-tokens@3.0.1 
  │ │ ├─┬ babel-generator@6.24.0 
  │ │ │ ├── babel-runtime@6.23.0 
  │ │ │ ├── detect-indent@4.0.0 
  │ │ │ ├── jsesc@1.3.0 
  │ │ │ └── trim-right@1.0.1 
  │ │ ├─┬ babel-helpers@6.23.0 
  │ │ │ └── babel-runtime@6.23.0 
  │ │ ├─┬ babel-messages@6.23.0 
  │ │ │ └── babel-runtime@6.23.0 
  │ │ ├── babel-runtime@6.23.0 
  │ │ ├─┬ babel-template@6.23.0 
  │ │ │ └── babel-runtime@6.23.0 
  │ │ ├─┬ babel-traverse@6.23.1 
  │ │ │ ├── babel-runtime@6.23.0 
  │ │ │ ├── globals@9.16.0 
  │ │ │ └─┬ invariant@2.2.2 
  │ │ │   └── loose-envify@1.3.1 
  │ │ ├─┬ babel-types@6.23.0 
  │ │ │ ├── babel-runtime@6.23.0 
  │ │ │ └── to-fast-properties@1.0.2 
  │ │ ├── babylon@6.16.1 
  │ │ ├── convert-source-map@1.4.0 
  │ │ ├── json5@0.5.1 
  │ │ ├── private@0.1.7 
  │ │ ├── slash@1.0.0 
  │ │ └── source-map@0.5.6 
  │ ├─┬ babel-runtime@6.23.0 
  │ │ └── regenerator-runtime@0.10.3 
  │ ├── core-js@2.4.1 
  │ ├─┬ home-or-tmp@2.0.0 
  │ │ ├── os-homedir@1.0.2 
  │ │ └── os-tmpdir@1.0.2 
  │ ├─┬ mkdirp@0.5.1 
  │ │ └── minimist@0.0.8 
  │ └── source-map-support@0.4.12 
  ├─┬ babel-runtime@6.18.0 
  │ └── regenerator-runtime@0.9.6 
  ├── bluebird@3.5.0 
  ├── colors@1.1.2 
  ├─┬ fs-promise@1.0.0 
  │ ├── any-promise@1.3.0 
  │ ├── fs-extra@1.0.0 
  │ ├── mz@2.6.0 
  │ └─┬ thenify-all@1.6.0 
  │   └── thenify@3.2.1 
  ├── node-abi@1.3.3 
  ├─┬ node-gyp@3.5.0 
  │ ├── fstream@1.0.11 
  │ ├─┬ nopt@3.0.6 
  │ │ └── abbrev@1.1.0 
  │ ├─┬ npmlog@4.0.2 
  │ │ ├─┬ are-we-there-yet@1.1.2 
  │ │ │ └── delegates@1.0.0 
  │ │ ├── console-control-strings@1.1.0 
  │ │ ├─┬ gauge@2.7.3 
  │ │ │ ├── aproba@1.1.1 
  │ │ │ ├── has-unicode@2.0.1 
  │ │ │ └── wide-align@1.1.0 
  │ │ └── set-blocking@2.0.0 
  │ ├── osenv@0.1.4 
  │ └─┬ tar@2.2.1 
  │   └── block-stream@0.0.9 
  ├─┬ ora@0.3.0 
  │ ├─┬ chalk@1.1.3 
  │ │ ├── ansi-styles@2.2.1 
  │ │ ├── escape-string-regexp@1.0.5 
  │ │ ├── has-ansi@2.0.0 
  │ │ └── supports-color@2.0.0 
  │ ├─┬ cli-cursor@1.0.2 
  │ │ └─┬ restore-cursor@1.0.1 
  │ │   ├── exit-hook@1.1.1 
  │ │   └── onetime@1.1.0 
  │ ├── cli-spinners@0.2.0 
  │ └── log-symbols@1.0.2 
  ├─┬ spawn-rx@2.0.10 
  │ ├── lodash.assign@4.2.0 
  │ └─┬ rxjs@5.2.0 
  │   └── symbol-observable@1.0.4 
  └─┬ yargs@3.32.0 
    ├─┬ cliui@3.2.0 
    │ └── wrap-ansi@2.1.0 
    ├─┬ os-locale@1.4.0 
    │ └─┬ lcid@1.0.0 
    │   └── invert-kv@1.0.0 
    ├── window-size@0.1.4 
    └── y18n@3.2.1 
```

在 `scripts` 添加 `rebuild-modules` 项如下

```
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:19]
└─[$] <git:(master*)> cat package.json        
{
  "name": "electron-quick-start",
  "version": "1.0.0",
  "description": "A minimal Electron application",
  "main": "main.js",
  "scripts": {
    "start": "electron .",
    "rebuild-modules": "electron-rebuild"
  },
  "repository": "https://github.com/electron/electron-quick-start",
  "keywords": [
    "Electron",
    "quick",
    "start",
    "tutorial",
    "demo"
  ],
  "author": "GitHub",
  "license": "CC0-1.0",
  "devDependencies": {
    "electron": "^1.4.1",
    "electron-rebuild": "^1.5.7",
    "java": "^0.8.0"
  }
}
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:20]
└─[$] <git:(master*)> npm run rebuild-modules 

> electron-quick-start@1.0.0 rebuild-modules /Users/lijianlin/Projects/ROLL-GUI
> electron-rebuild

✔ Rebuild Complete
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:21]
└─[$] <git:(master*)> electron .
{ http_parser: '2.7.0',
  node: '7.4.0',
  v8: '5.6.326.50',
  uv: '1.10.1',
  zlib: '1.2.8',
  ares: '1.10.1-DEV',
  modules: '53',
  openssl: '1.0.2j',
  electron: '1.6.2',
  chrome: '56.0.2924.87',
  'atom-shell': '1.6.2' }
^C
```
忘记执行 ```postInstall.js``` 会得到如下错误

```bash
Error: Cannot find module '../build/jvm_dll_path.json'
    at Function.Module._resolveFilename (module.js:470:15)
    at Function.Module._load (module.js:418:25)
    at Module.require (module.js:498:17)
    at require (internal/module.js:20:19)
    at Object.<anonymous> (/Users/lijianlin/Projects/testnodejava/node_modules/java/lib/nodeJavaBridge.js:3:21)
    at Module._compile (module.js:571:32)
    at Object.Module._extensions..js (module.js:580:10)
    at Module.load (module.js:488:32)
    at tryModuleLoad (module.js:447:12)
    at Function.Module._load (module.js:439:3)
```
我当时以为`rebuild`必须要写参数，后来终于想起来是忘记了那个`postInstall.js`脚本。

```bash
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:21]
└─[$] <git:(master*)> npm run rebuild-modules java
> electron-quick-start@1.0.0 rebuild-modules /Users/lijianlin/Projects/ROLL-GUI
> electron-rebuild "java"

✔ Rebuild Complete
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:21]
└─[$] <git:(master*)> electron .
{ http_parser: '2.7.0',
  node: '7.4.0',
  v8: '5.6.326.50',
  uv: '1.10.1',
  zlib: '1.2.8',
  ares: '1.10.1-DEV',
  modules: '53',
  openssl: '1.0.2j',
  electron: '1.6.2',
  chrome: '56.0.2924.87',
  'atom-shell': '1.6.2' }
^C
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:22]
└─[$] <git:(master*)> node ./node_modules/java/postInstall.js 
┌─[lijianlin@Chewbacca] - [~/Projects/ROLL-GUI] - [14, 07:22]
└─[$] <git:(master*)> electron .                              
{ http_parser: '2.7.0',
  node: '7.4.0',
  v8: '5.6.326.50',
  uv: '1.10.1',
  zlib: '1.2.8',
  ares: '1.10.1-DEV',
  modules: '53',
  openssl: '1.0.2j',
  electron: '1.6.2',
  chrome: '56.0.2924.87',
  'atom-shell': '1.6.2' }
Worf!
Aooo!
!
ok
2017-03-14 19:22:58.414 Electron Helper[52990:3098564] Couldn't set selectedTextBackgroundColor from default ()
```

`Dog.jar`中的主类，需要 java 8 才能运行。

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Dog {
    public List<String> dogLanguage = Arrays.asList(new String[]{"Worf", "Aooo"});

    public Dog() {
    }

    public String canYouSpeak() {
        String t = "!";
        this.dogLanguage.forEach((s) -> {
            System.out.println(s + t);
        });
        return t;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        String res = dog.canYouSpeak();
        System.out.println(res);
    }
}

```

来源 

- [Github electron/electron issue DLL initialization routine failed (with java integration) #8638](https://github.com/electron/electron/issues/8638#issuecomment-278807945)
- [Github joeferner/node-java issue Electron/Java compatiblity? #379](https://github.com/joeferner/node-java/issues/379) 

#node-java on OS X

一开始```node testjava.js```老提示我缺少`Java SE 6`，我差点就去装苹果官网的安装包了。

- If you run into strange runtime issues, it could be because the Oracle JDK does not advertise itself as available for JNI. See Issue 90 for more details and manual workarounds. If this does occur for you, please update the issue.

上面提到的 issue 里面有人说是 `Java 8` 的 bug，可以通过修改配置文件允许`JNI`,不知道将来发布会不会有麻烦。

我既修改了`/Library/Java/JavaVirtualMachines/jdk1.8.0_71.jdk/Contents/Info.plist` 又`brew cask install java7`了。

```bash
┌─[lijianlin@Chewbacca] - [~/Projects/testnodejava] - [14, 05:54]
└─[$] <> brew cask install java7
Warning: The default Caskroom location has moved to /usr/local/Caskroom.

Please migrate your Casks to the new location and delete /opt/homebrew-cask/Caskroom,
or if you would like to keep your Caskroom at /opt/homebrew-cask/Caskroom, add the
following to your HOMEBREW_CASK_OPTS:

  --caskroom=/opt/homebrew-cask/Caskroom

For more details on each of those options, see https://github.com/caskroom/homebrew-cask/issues/21913.
==> Caveats
This Cask makes minor modifications to the JRE to prevent any packaged
application issues.

If your Java application still asks for JRE installation, you might need to
reboot or logout/login.

The JRE packaging bug is discussed here:

    https://bugs.eclipse.org/bugs/show_bug.cgi?id=411361

Installing this Cask means you have AGREED to the Oracle Binary Code License
Agreement for Java SE at

    http://www.oracle.com/technetwork/java/javase/terms/license/index.html

==> Downloading http://download.oracle.com/otn-pub/java/jdk/7u80-b15/jdk-7u80-macosx-x64.dmg
######################################################################## 100.0%
==> Verifying checksum for Cask java7
==> Running installer for java7; your password may be necessary.
==> Package installers may write to any location; options such as --appdir are ignored.
==> installer: Package name is JDK 7 Update 80
==> installer: Installing at base path /
==> installer: The install was successful.
🍺  java7 was successfully installed!
```
`brew`虽然提示装上了，但是系统偏好设置-Java 里面又没看到有1.7。但是最后可以运行`node-java`了。

## Something else

https://paste.ubuntu.com/24175397/
>我调研了一下发现有点走火入魔了
>
>首先说一下 node-java 是怎么写的。
第一个步 js 和 c++ 的 bridge 。v8引擎是 c++ 写的所以这个事情好像也很合理。
>（http://deadhorse.me/nodejs/2012/10/09/c_addon_in_nodejs_object.html）
>
> 第二步 c++ 通过 JNI 动态链接 jre 的 jvm.dll 来调用 java 类 
>（http://www.ibm.com/developerworks/java/tutorials/j-jni/j-jni.html）
>
> 这好像就过于魔幻了,一次 js 和 java 的交互 对象在内存里依次这样转换
>
> js obj <-> c++ V8.h 定义的对象 <-> c++ jni.h 定义的对象 <-> java 对象
> 
>虽然我觉得我们这个情况性能瓶颈在算法又不在 IO，这倒是没啥毛病。但是直接写 javaseverlet 好像简单点。。。。
>
>因为想要快速开发和用 D3.js 画图，所以 Web 前端跑不了
>
>因为算法用 Java 写的，所以 Java 也跑不了。
>
>所以目前是  注入JavaFX 的 WebView的方案。
>
>我个人觉得 JavaFX 不够炫酷（大雾，有界面卡顿掉帧，渲染不一致，调试不方便等问题）想试试 electron。
>
>感觉跨语言调用比通过文件/管道直接在exec运行 jar 好写，于是又找了个 Bridging 库。。。
>
>为了写五六百行的代码，感觉绕了贼大一个圈子。


#ipc
>Please install jquery in npm
```
npm install jquery
```

