package com.sistemasolare;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;

public class Selezione_galassie {
    private final String foto = "https://lh3.googleusercontent.com/fife/APg5EOY-TI-DLN0HAV8307QOa912yG9l1ckshNy3UBWIvgH8DdZGikgyPuzjxoOc0E0NdbxsBNUEhSIykWTAevZ5NUFOT8RgUGYXXdQQVdxhkugJ_hQQtNu22JzGoOBEFhaQoW2gT4eDppeb6JZKkTTs-jBT5ux7IUbrK_xsVzxuRLlPkbT5MdJvj5hL3yNaXPB8TmlTbFZAw0ENe4SyJUR2ZKgmR4kGCcrZGPVB0dxwFsvYkLEm3UYR7aE_Cz-53OqXfkmhDLB8clx5u6lxvFff5uRnkjHxX8ABWds4sVbXXq1Avwty-Xx8zb5M2KTCXYQ5GPAa_16AWs4CYpBEPAPBWIp2YKHb5b-_Cb6WxVVMpoCDz9YCPxXsg6dxWDFRM4qlQtMD_tDnHoR_c8U4IF6lilLPJ5KMh52jCELZVeL2rp2CGN-ZDWmz-Ta0p_YgfdD7LEVxomk3env6jahMscsUu4W1pOcbUrG0EvSWXQGqIGbqPf8ZQfpM6-qhK3uKQYF-Ua5Sf563SCdXv9HijGWQ0XujqD_sKxs9nnHd-eCASX2HLUDib3Tc-96NPm11kUn24ZpUbbsm_Wh_LR7OZqPm0uLcQC6om7Duq9Lw6nJ8gmAq3RqwB2-VRvDD35_FxOG2QUbkVhJXc7UBYcMI8p7NNuKciArrp4aX6_aSc-KLJqGF-WIYaa25WRphyhnYeIZJpyv21ecKRBgZppxrt7MzIR9ESpVSCrIAu6NUP1-gfSLybMJ4HI0mXu3ivW9AKBUbujzmwAh83fDcobFRoI0nA1Hesl_M9H7Yt0eiEJajQNVzyPvlPsP_gfbxu1zoKNUTxDntg1SQwSNWhaegA_dLQXMeqcIDu4z5c6RRMp2AHlL8FiDh2teCEZyVI_K3eROUw6odtUDHHccdVk2bzNW_miIXdFhufnrDw6rRYRl3QmNTCy8-Yi3umX0ka-gzrcix9oouEpEqptbzCrT01VKkYBgGUk5rl59Na1RiKU7pXwN3un_kxXVQsE5HTdt5r1PJ0B_HwGdTdos6YvrL8bU-34RHD6Y9KmylVQ94cxMYiBYXQW3E8ZHBgjw3toKsDR1jjNhgdkDTo1lH7A5oqTkFkHfcwhhZULdRgKNDG0ak2EYiGQAAEmX3hK8hJJnDiDKi_O7yUlkveDwHXe6xG7Jp-zLnC4LmOMW1yqaCu2mxHvrTAfXaLu4mJfDw52GJRTbXMt_oNQ9o9y1hzf4R-B89e_XCm-yGj5WfOQ3637y735UxG-FEhm2ZqseXUOqfcqO-WeP7eJ6gzVcWkVAl_1zr1_uflv6V3lscBx9xS-zHPU3KD0gm29bA2G4DuILfB-b3lpcO4y2rM1OIJWVhTCV5c-BO4LqXecvM3gsSk9heou4goNLgixaXcZDnSOeDrXR0LYxL_55JHI93hJtzNmizDlP9WS1eYQwmMpFq8k2zPn_RbwK8kDpj-4m8VRdZ9uISCVNlFJLjW7sTWM6qunksx45QLbaIyFqyDw4y41fYTdmjces5HJFgFsZeAIJ_FaDu6rvjJ8dU-Wa5JbdP_KTCAojRq9KpdTJ6cCqhjfc";
    private final AnchorPane root;
    private final Stage stage;
    private Rectangle rectangle;

    private int selected;

    Selezione_galassie(Stage stage, AnchorPane menu) throws MalformedURLException {
        this.stage = stage;
        this.root = menu;
    }

    public void start() {
        stage.getScene().getRoot().setStyle("-fx-background-image: url('" + foto + "') ;");
        rectangle = new Rectangle(80, 100, 418, 500);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(10);
        root.getChildren().add(rectangle);
        selected = 1;
    }

    public void right() {
        switch(selected) {
            case 1:
                selected ++;
                rectangle.setX(rectangle.getX() + 480);
                System.out.println(selected);
                break;
            case 2:
                selected ++;
                rectangle.setX(rectangle.getX() + 500);
                System.out.println(selected);
                break;
            default:
                break;
        }
    }

    public void left() {
        switch(selected) {
            case 2:
                selected --;
                rectangle.setX(rectangle.getX() - 480);
                System.out.println(selected);
                break;
            case 3:
                selected --;
                rectangle.setX(rectangle.getX() - 500);
                System.out.println(selected);
                break;
            default:
                break;
        }
    }

    public int enter() {
        return selected;
    }
}
