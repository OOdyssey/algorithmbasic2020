package class04;

public class Code01_MergeSort_lc {

    public static void mergeSort1(int[] arr) {
        if (arr.length == 1 || arr.length == 0)
            return;

        process(arr, 0, arr.length -1);
    }

    public static void process(int[] arr, int L, int R) {

        if (L >= R)
            return;

        int mid = L + ((R - L) >> 1);

        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, R, mid);
    }

    public static void merge(int[] arr, int L, int R, int M) {

        int[] tmpArr = new int[R - L + 1];

        int pl = L;
        int pr = M + 1;

        int i = 0;
        while (pl <= M && pr <= R) {
            tmpArr[i++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }

        while (pl <= M) {
            tmpArr[i++] = arr[pl++];
        }

        while (pr <= R) {
            tmpArr[i++] = arr[pr++];
        }

        i = 0;
        pl = L;
        while(pl <= R) {
            arr[pl++] = tmpArr[i++];
        }
    }


    public static void mergeSort2(int[] arr) {
        int R = arr.length - 1;

        int mergesize = 1;

        while (mergesize < arr.length) {

            int l = 0;
            while (l < R) {

                int mid = l + mergesize - 1;
                if (mid >= R)
                    break;

                int r = Math.min(R, mid + mergesize);


                merge(arr, l, r, mid);
                l = r + 1;
            }

            mergesize <<= 1;
        }


    }


}
