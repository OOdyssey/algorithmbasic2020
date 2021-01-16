package class04;

public class Code03_ReversePair_lc {

    public static int reverPairNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R)
            return 0;
        int mid = L + (R - L) / 2;

        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int M, int R) {

        int pl = M;
        int pr = R;

        int[] tmparr = new int[R- L +1];
        int i = R- L;
        int res = 0;

        while ( pl >= L && pr >= M + 1) {
            if (arr[pl] > arr[pr])
                res += pr - M;
            tmparr[i--] = arr[pl] > arr[pr] ? arr[pl--] : arr[pr--];
        }

        while (pl >= L ) {
            tmparr[i--] = arr[pl--];
        }

        while (pr >= M+1) {
            tmparr[i--] = arr[pr--];
        }

        i = 0;
        pl = L;
        while (pl <= R) {
            arr[pl++] = tmparr[i++];
         }

        return res;
    }

    public static int reverPairNumberNonRecursion(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;

        int stepSize = 1;
        int L = 0;

        while(stepSize < arr.length) {
            int R = arr.length - 1;
            while(R > L) {
                int mid = R - stepSize;
                int pl = Math.max(0,mid - stepSize + 1);
                if (mid + 1 <= L)
                    break;

                res += merge(arr,pl,mid,R);

                R = pl - 1;

            }


            stepSize *= 2;
        }

        return res;
    }
}
