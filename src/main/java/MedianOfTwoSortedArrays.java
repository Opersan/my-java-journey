import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[2], nums2 = new int[1];

        nums1[0] = 1;
        nums1[1] = 3;

        nums2[0] = 2;

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) {
            if(nums2.length == 0) {
                return 0;
            } else {
                return median(nums2, nums2.length);
            }
        }
        if(nums2.length == 0) {
            if(nums1.length == 0) {
                return 0;
            } else {
                return median(nums1, nums1.length);
            }
        }
        int[] arr = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0;

        for(int i = 0; i < arr.length; i++) {
            if(nums1[index1] < nums2[index2]) {
                arr[i] = nums1[index1];
                if(index1 + 1 != nums1.length) index1++;
                else {
                    i++;
                    for(int j = index2; j < nums2.length; j++) {
                        arr[i] = nums2[index2];
                        index2++;
                        i++;
                    }
                    break;
                }
            } else {
                arr[i] = nums2[index2];
                if(index2 + 1 != nums2.length) index2++;
                else {
                    i++;
                    for(int j = index1; j < nums1.length; j++) {
                        arr[i] = nums1[index1];
                        index1++;
                        i++;
                    }
                    break;
                }
            }
        }

        return median(arr, nums1.length + nums2.length);
    }

    public static double median(int[] arr, int a) {
        if(a % 2 == 0) {
            int median = a / 2;
            return (double)(arr[median - 1] + arr[median]) / 2;
        } else {
            int median = a / 2;
            return arr[median];
        }
    }

}
