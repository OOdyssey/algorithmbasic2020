package class04;

public class Code02_SmallSum_lc {

    public static int smallSum(int[] arr) {
        if (arr.length <= 1)
            return 0;

        return process(arr, 0, arr.length - 1);

    }

    public static int process(int[] arr, int L, int R) {
        if (L >= R)
            return 0;

        int mid = L + (R - L) / 2;

        return process(arr, L, mid) +
                process(arr, mid + 1, R) +
                merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int pl = L;
        int pr = M + 1;

        int[] tmparr = new int[R - L + 1];
        int i = 0;
        int res = 0;
        while (pl <= M && pr <= R) {
            if (arr[pl] < arr[pr]) {
                res += (R - pr + 1) * arr[pl];
            }

            tmparr[i++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }

        while (pl <= M) {
            tmparr[i++] = arr[pl++];
        }

        while (pr <= R) {
            tmparr[i++] = arr[pr++];
        }

        i = 0;
        pl = L;
        while(pl <= R) {
            arr[pl++] = tmparr[i++];
        }
//        while (i < tmparr.length) {
//            arr[pl++] = tmparr[i++];
//
//        }
        return res;
    }

    public static int smallSumNonRecursion(int[] arr) {
        if (arr.length <= 1)
            return 0;

        int L = 0;
        int R = arr.length - 1;
        int stepSize  = 1;
        int res = 0;
        while (stepSize <= arr.length) {
            int pl = L;

            while (pl <= arr.length) {
                int mid = pl + stepSize - 1;
                int pr = Math.min(mid + stepSize, R) ;
                if (mid >= R) {
                    break;
                }
                res += merge(arr,pl,mid,pr);

                pl = pr + 1;
            }


            stepSize *= 2;


        }

        return res;
    }

}
