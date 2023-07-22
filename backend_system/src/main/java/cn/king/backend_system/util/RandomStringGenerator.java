package cn.king.backend_system.util;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomStringGenerator {
    //这是一个生成随机字符串的工具类
    //先生成一个有大写字母、小写字母和数字的字符串
    //让随机数随机抽选，达到输出一个随机字符串的目的
    //但是我是向做一个cdk抽奖活动
    //那么这个随机数中就不能有重复的字符串
    //get给出的方案是用set,不能添加重复value的特性
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    //将这个方法私有
    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    //生成规定数量，不重复随机字符串的方法
    //给如要生成的数量，和要要生成字符串的长度
    public  Set<String> NotRepeatingRandomString(Integer num, Integer length){
        Set<String> set = new HashSet<>();
        //字符串不到规定数量时，就是true
        //当到来规定的数量，就是false
        while (set.size()!=num){
            set.add(generateRandomString(length));
        }
        return set;
    }


}
