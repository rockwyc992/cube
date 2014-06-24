cube
====
ce1002 final project

0. 請確認您的電腦有Leap SDK、OpenGL、搖桿驅動
1. 控制方式: 
w a s d 或是 左蘑菇頭 前後左右移動
上下左右 或是 右蘑菇頭 切換視角
shift    或是 Lt按鈕   向下移動
空白鍵   或是 Rt按鈕   向上移動

ARb       或是 一根手指順時針畫圈 F 旋轉
AARb      或是 兩根手指順時針畫圈 f(b') 旋轉
YLb       或是 三根手指順時針畫圈 B'旋轉

YRb       或是 一根手指逆時針畫圈 B 旋轉
YYRb      或是 兩根手指逆時針畫圈 b(f') 旋轉
ALb       或是 三根手指逆時針畫圈 F'旋轉

右Rb      或是 一根手指向上 R 旋轉
右右Rb    或是 兩根手指向上 r(l') 旋轉
左Lb      或是 三根手指向上 L'旋轉

左Rb      或是 一根手指向下 L 旋轉
左左Rb    或是 兩根手指向下 l(r') 旋轉
右Lb      或是 三根手指向下 R'旋轉

上Rb      或是 一根手指向左 U 旋轉
上上Rb    或是 兩根手指向左 u(d') 旋轉
下Lb      或是 三根手指向左 D'旋轉

下Rb      或是 一根手指向右 D 旋轉
下下Rb    或是 兩根手指向右 d(u') 旋轉
上Lb      或是 三根手指向右 U'旋轉

esc鍵    或是 back按鈕 退出程式
Logo鍵   自動轉好/自動轉亂
r鍵      視角回到原點

P.S. RLFBUD = Right Left Front Back Up Down

2. 如果選擇 Is_Gamepad = false, 預設強制Is_AI = false
3.  AI.java      => 用Stack自動轉好
    Camera.java  => OpenGL的Camera
    Colors.java  => 顏色用的小class
    Control.java => Leap motion、搖桿、鍵盤的控制
    Cube.java    => cube的繪圖(包括動畫)
    Demo.java    => main class
    Global.java  => 設定檔
    Leap_listener.java => Leap的控制
    Point.java   => x, y, z
    Rubiks.java  => 方塊的狀態
