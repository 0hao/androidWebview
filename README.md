androidWebview，收集整理版
==============
通过安卓webview创建的app应用框架（还没到页面细节实现），没有使用phoneGap之类的工具。使用对象是不需要调用设备硬件操作的页面，而其他硬件操作需求由java去实现，同时java和js之间进行通信交互。

assets/ 是web资源文件，html css js image等，这里用了seajs加载，zepto类库，backbone框架。

java代码用到了一个对WebChromeClient的扩展组件--MyWebChromeClient，用于实现js的alert confirm prompt等功能，但还是建议使用js自定义相关控件，理由：原生弹窗的界面不好看，back建开启和关闭会引发一些问题和体验的不足。
