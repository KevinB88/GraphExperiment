public class Pair<T> {
        private T data_value_1;
        private T data_value_2;

        public Pair(T data_value_1, T data_value_2){
            this.data_value_1 = data_value_1;
            this.data_value_2 = data_value_2;
        }

        public T get_first(){
            return data_value_1;
        }

        public T get_second(){
            return data_value_2;
        }
}
