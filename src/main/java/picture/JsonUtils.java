package picture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static ObjectMapper defaultMapper = new ObjectMapper();

    public void setObjectMapper(ObjectMapper mapper) {
        defaultMapper = mapper;
    }

    /**
     * 序列化成字符串
     */
    public static String toJson(Object value) {
        return toJson(defaultMapper, value);
    }

    /**
     * 序列化成字符串
     */
    public static String toJson(final ObjectMapper mapper, Object value) {
        if (value == null) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {
            return _mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            System.out.println("序列化错误: value=" + value);
        }
        return null;
    }

    /**
     * 根据类型反序列化为对象
     */
    public static <T> T parse(String value, Class<T> clasz) {
        return parse(defaultMapper, value, clasz);
    }

    /**
     * 根据类型反序列化为对象
     */
    public static <T> T parse(final ObjectMapper mapper, String value, Class<T> clasz) {
        if (clasz == null) {
            throw new IllegalArgumentException("clasz is null");
        }
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {
            setConfigure(_mapper);
            return _mapper.readValue(value, clasz);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("反序列化错误: class=" + clasz + ", value=" + value);
        }
        return null;
    }

    public static <T> T parse(String value, Type type) {
        return parse(defaultMapper, value, type);
    }

    public static <T> T parse(final ObjectMapper mapper, String value, Type type) {
        if (type == null) {
            throw new IllegalArgumentException("type is null");
        }
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {
            setConfigure(_mapper);
            return _mapper.readValue(value, mapper.constructType(type));
        } catch (IOException e) {
            System.out.println("反序列化错误: type="+ type+ ", value="+ value);
        }
        return null;
    }

    public static ObjectMapper constructObjectMapperForArrayObjectConfuse() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.addHandler(new ArrayObjectConfuseDeserializationProblemHandler());
        return mapper;
    }

    public static JavaType constructParametricType(Class<?> parametrized, Class... parameterClasses) {
        return constructParametricType(defaultMapper, parametrized, parameterClasses);
    }

    public static JavaType constructParametricType(ObjectMapper mapper, Class<?> parametrized, Class... parameterClasses) {
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        return _mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    public static <T> T parse(String value, JavaType javaType) {
        return parse(defaultMapper, value, javaType);
    }

    public static <T> T parse(final ObjectMapper mapper, String value, JavaType javaType) {
        if (javaType == null) {
            throw new IllegalArgumentException("javaType is null");
        }
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {
            setConfigure(_mapper);
            return _mapper.readValue(value, javaType);
        } catch (IOException e) {
            System.out.println("反序列化错误: javaType=" + javaType + ", value=" + value);
        }
        return null;
    }

    /**
     * 根据类型反序列化为对象
     */
    public static <T> T parse(byte[] value, Class<T> clasz) {
        return parse(defaultMapper, value, clasz);
    }

    /**
     * 根据类型反序列化为对象
     */
    public static <T> T parse(final ObjectMapper mapper, byte[] value, Class<T> clasz) {
        if (clasz == null) {
            throw new IllegalArgumentException("clasz is null");
        }
        if (value == null) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {
            setConfigure(_mapper);
            return _mapper.readValue(value, clasz);
        } catch (IOException e) {
            System.out.println("反序列化错误: class=" + clasz + ", value="+ value);
        }
        return null;
    }

    /**
     * 根据类型反序列化为对象
     */
    public static <T> T parse(Object value, Class<T> clasz) {
        return parse(defaultMapper, value, clasz);
    }

    /**
     * 根据类型反序列化为对象
     *
     * @param value
     * @param valueTypeRef 自定义返回类型如: new TypeReference<List<Long>>(){}
     * @param <T>
     * @return
     */
    public static <T> T parse(Object value, TypeReference valueTypeRef) {
        return parse(defaultMapper, value, valueTypeRef);
    }

    /**
     * 根据类型反序列化为对象
     */
    public static <T> T parse(final ObjectMapper mapper, Object value, Class<T> clasz) {
        if (clasz == null) {
            throw new IllegalArgumentException("clasz is null");
        }
        if (value == null) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {

            setConfigure(_mapper);
            if (value instanceof String) {
                return _mapper.readValue((String) value, clasz);
            } else if (value instanceof byte[]) {
                return _mapper.readValue((byte[]) value, clasz);
            } else {
                throw new IllegalArgumentException("value should be String or byte[]");
            }
        } catch (IOException e) {
            System.out.println("反序列化错误: class="+ clasz+ ", value="+ value);
        }
        return null;
    }

    /**
     * 根据类型反序列化为对象
     */
    public static <T> T parse(final ObjectMapper mapper, Object value, TypeReference valueTypeRef) {
        if (valueTypeRef == null) {
            throw new IllegalArgumentException("valueTypeRef is null");
        }
        if (value == null) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {

            setConfigure(_mapper);
            return _mapper.readValue((String) value, valueTypeRef);
        } catch (IOException e) {
            System.out.println("反序列化错误: valueTypeRef=" + valueTypeRef + ", value=" + value);
        }
        return null;
    }

    /**
     * 根据类型反序列化为对象数组
     */
    public static Object[] parseArray(String value,
                                      Class<?>[] classes) {
        return parseArray(defaultMapper, value, classes);
    }

    /**
     * 根据类型反序列化为对象数组
     */
    public static Object[] parseArray(final ObjectMapper mapper, String value,
                                      Class<?>[] classes) {
        if (classes == null || classes.length == 0) {
            throw new IllegalArgumentException("classes is null or empty");
        }
        if (value == null || "".equals(value.trim())) {
            return null;
        }
//        ObjectMapper _mapper = mapper;
//        if (_mapper == null) {
//            _mapper = defaultMapper;
//        }
        try {
            JsonNode jsonNode = mapper.readTree(value);
            if (jsonNode.isArray() && jsonNode.size() == classes.length) {
                int index = 0;
                List<Object> list = new ArrayList<Object>();
                for (JsonNode element : jsonNode) {
                    list.add(mapper.readValue(element.toString(), classes[index]));
                    index++;
                }
                return list.toArray();
            } else {
                throw new IllegalArgumentException("value is not an array, or incorrect length of classes");
            }
        } catch (IOException e) {
            StringBuilder builder = new StringBuilder();
            for (Class<?> clasz : classes) {
                builder.append(clasz).append(",");
            }
            System.out.println("反序列化错误: classes=" + builder.toString() + " value=" + value);
        }
        return null;
    }

    public static <T> T[] parseArrayByElementClass(String value, Class<T> clazz) {
        return parseArrayByElementClass(defaultMapper, value, clazz);
    }

    /**
     * 根据类型反序列化为对象数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] parseArrayByElementClass(final ObjectMapper mapper, String value,
                                                   Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("classes is null or empty");
        }
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        ObjectMapper _mapper = mapper;
        if (_mapper == null) {
            _mapper = defaultMapper;
        }
        try {
            JsonNode jsonNode = mapper.readTree(value);
            if (jsonNode.isArray()) {
                List<T> list = new ArrayList<>();
                for (JsonNode element : jsonNode) {
                    list.add(mapper.readValue(element.toString(), clazz));
                }
                return (T[]) list.toArray();
            } else {
                throw new IllegalArgumentException("value is not an array, or incorrect length of classes");
            }
        } catch (IOException e) {
            StringBuilder builder = new StringBuilder();
            builder.append(clazz);
            System.out.println("反序列化错误: classes=" + builder.toString() + " value=" + value);
        }
        return null;
    }

    public static void setConfigure(final ObjectMapper mapper) {

        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static void main(String[] args) throws IOException {
        String list = "[11106, 6334, 13781, 11832, 7358, 4683, 12613, 12331, 11926, 11993, 13263, 11239, 9153, 9152, 9154, 12234, 817, 12311, 12750, 12376, 12575, 3420, 12614, 12748, 13978, 3179, 12370, 3181, 7703, 10902, 10016, 3627, 12831, 3632, 7950, 3759, 12601, 7822, 12256, 7707, 9069, 9377, 7708, 645, 9949, 5050, 4471, 4948, 8434, 9068, 4950, 4470, 9067, 4058, 8435, 4468, 4338, 4648, 8433, 4647, 8213, 3628, 3945, 3944, 4056, 10161, 3579, 11052, 9956, 78, 12239, 9622, 11164, 9368, 9779, 8179, 3558, 3582, 3261, 11728, 11048, 2138, 12931, 176, 9241, 10904, 9954, 773, 6909, 12930, 9953, 9376, 9968, 4344, 7497, 9238, 12605, 1089, 12387, 12386, 2785, 1484, 6145, 12394, 10178, 12741, 11145, 10204, 10203, 9778, 11512, 12752, 852, 3838, 12391, 2885, 11730, 2739, 3280, 12723, 9575, 9478, 12935, 10343, 10342, 10878, 12689, 3270, 30, 9479, 8310, 9480, 1919, 10344, 9576, 11056, 10205, 10528, 12253, 13110, 3837, 12745, 9574, 9958, 9572, 3272, 282, 11046, 13744, 2743, 11518, 11729, 12695, 9780, 13502, 12384, 6674, 9571, 9783, 9793, 6908, 13107, 2178, 3840, 11726, 6299, 9573, 10535, 12936, 11733, 10871, 11045, 4767, 9955, 11516, 12029, 3631, 12255, 11287, 4231, 11055, 6298, 2375, 2741, 11727, 12392, 8313, 12252, 6648, 1732, 11732, 12343, 2742, 3946, 1579, 10527, 12036, 3264, 12684, 6773, 12395, 4227, 4223, 12039, 12027, 11723, 620, 13717, 13926, 2227, 8300, 9792, 10865, 9242, 13108, 12929, 13677, 10175, 3481, 12742, 10869, 11519, 11929, 12694, 10340, 12732, 9960, 1922, 4345, 12696, 11049, 12751, 13718, 12033, 6301, 12031, 9240, 12691, 13676, 11725, 13285, 13276, 3419, 11517, 10174, 10539, 9684, 9373, 5142, 12025, 3633, 12724, 6917, 10903, 10875, 10874, 4684, 8552, 13680, 7142, 12390, 12026, 2607, 13927, 12242, 12934, 11047, 4228, 10540, 9372, 12926, 3266, 10541, 10171, 772, 2783, 12921, 2226, 13104, 13277, 12693, 10015, 13271, 13259, 9777, 13675, 2672, 9608, 2232, 13109, 10879, 12941, 12932, 9614, 13284, 8197, 12023, 5147, 8318, 2469, 12603, 614, 13272, 7304, 12740, 11292, 13274, 6149, 9374, 2376, 3262, 9785, 10872, 11522, 13925, 1475, 13102, 13928, 13283, 3584, 8307, 11051, 10172, 4225, 13279, 10544, 12243, 9473, 13273, 13103, 12685, 11520, 9370, 4461, 11715, 12940, 13275, 10532, 12388, 11524, 10868, 10177, 4059, 12729, 9859, 11717, 5148, 12267, 13106, 10543, 11523, 2338, 12082, 12021, 13262, 9861, 10880, 12690, 406, 1357, 13257, 9796, 12682, 11722, 9578, 13280, 13260, 8317, 13281, 11514, 13278, 9378, 11724, 1058, 7946, 9569, 11721, 13681, 10176, 2374, 3634, 8087, 13719, 8315, 12923, 1786, 10873, 12739, 12747, 5145, 13282, 11053, 12264, 10530, 11289, 10877, 142, 7831, 10173, 11521, 4985, 2135, 10526, 13679, 5622, 12945, 9371, 8558, 6151, 10870, 12380, 1703, 12743, 6906, 9788, 2270, 12738, 10600, 13924, 12687, 13720, 8316, 12263, 612, 10601, 12265, 2377, 13678, 9570, 3055, 9567, 9568, 9247, 8878, 10876, 13965, 5146, 12938, 11294, 1471, 12383, 12924, 3949, 12269, 12944, 12081, 126, 4224, 8559, 2804, 12937, 226, 9384, 2228, 12726, 7945, 13105, 7836, 3899, 11932, 10533, 6148, 10355, 11513, 225, 2225, 13923, 9244, 12737, 4657, 12604, 12933, 9243, 12266, 2471, 12268, 13261, 9246, 12365, 1155, 13976, 12262, 1188, 2465, 9577, 13750, 10347, 4656, 12077, 11923, 12927, 10208, 13040, 10017, 9472, 1186, 11925, 5304, 12244, 9644, 10339, 10534, 4655, 11927, 12749, 11720, 12943, 12248, 13047, 3057, 12735, 9, 9860, 79, 12079, 1391, 12725, 7496, 8186, 10889, 13049, 8183, 13265, 10524, 12602, 13266, 12247, 12942, 7301, 91, 1785, 11924, 9245, 1649, 1981, 13922, 12246, 10888, 12744, 2229, 3122, 2467, 12217, 12928, 7097, 6297, 8303, 12249, 6554, 11044, 10353, 11525, 12080, 12746, 9239, 223, 1920, 12260, 13051, 1145, 3695, 11073, 1301, 146, 10336, 13982, 6147, 9689, 1783, 11719, 867, 116, 4747, 5933, 9301, 5181, 2460, 7099, 12721, 11299, 670, 145, 179, 12715, 12718, 3053, 6000, 2623]";
        TypeReference<List<Long>> valueTypeRef = new TypeReference<List<Long>>() {
        };
        List<Long> parses = parse(list, valueTypeRef);
        for (Long id : parses) {
            System.out.println(id);
        }
    }
}

